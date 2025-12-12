
package com.whale.framework.aspectj;

import com.alibaba.fastjson2.JSON;
import com.whale.admin.domain.SysOperLog;
import com.whale.common.core.domain.R;
import com.whale.common.utils.SecurityUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Aspect
@Component
@Slf4j
public class OperLogAspect {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // 线程局部变量，用于在方法调用前后传递数据
    private final ThreadLocal<SysOperLog> operLogThreadLocal = new ThreadLocal<>();
    private final ThreadLocal<Long> startTimeThreadLocal = new ThreadLocal<>();

    /**
     * 定义切点：所有Controller包下的方法，排除login接口
     */
    @Pointcut("execution(* org.openhis.web..controller..*.*(..)) "
        + "&& !execution(* org.openhis.web..controller..*.login(..)) ")
    public void operLogPointCut() {}

    /**
     * 前置通知：在方法执行前记录请求信息
     */
    @Before("operLogPointCut()")
    public void doBefore(JoinPoint joinPoint) {
        try {
            ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
            if (attributes == null) {
                return;
            }

            HttpServletRequest request = attributes.getRequest();
            MethodSignature signature = (MethodSignature)joinPoint.getSignature();
            Method method = signature.getMethod();

            // 创建操作日志对象
            SysOperLog operLog = new SysOperLog();
            operLog.setOperTime(new Date());
            operLog.setOperUrl(request.getRequestURI());
            operLog.setRequestMethod(request.getMethod());

            // 获取请求参数
            String operParam = getRequestParams(joinPoint, request);
            operLog.setOperParam(operParam);

            // 设置操作方法名
            String className = joinPoint.getTarget().getClass().getName();
            String methodName = method.getName();
            operLog.setMethod(className + "." + methodName + "()");

            // 保存到线程局部变量
            operLogThreadLocal.set(operLog);

            // 记录开始时间
            startTimeThreadLocal.set(System.currentTimeMillis());

        } catch (Exception e) {
            log.error("操作日志前置通知异常", e);
        }
    }

    /**
     * 返回通知：在方法成功执行后记录结果
     */
    @AfterReturning(pointcut = "operLogPointCut()", returning = "result")
    public void doAfterReturning(JoinPoint joinPoint, Object result) {
        try {
            SysOperLog operLog = operLogThreadLocal.get();
            if (operLog == null) {
                return;
            }

            // 计算消耗时间
            Long startTime = startTimeThreadLocal.get();
            if (startTime != null) {
                Long costTime = System.currentTimeMillis() - startTime;
                operLog.setCostTime(costTime);
            }

            // 设置操作结果
            if (result instanceof R) {
                R<?> r = (R<?>)result;
                operLog.setJsonResult(JSON.toJSONString(r));
                // 根据R的code判断操作状态
                if (r.getCode() != 200) { // 假设200是成功状态码
                    operLog.setStatus(1); // 失败
                    operLog.setErrorMsg(r.getMsg());
                }
            } else {
                operLog.setJsonResult(result != null ? JSON.toJSONString(result) : "null");
            }
            // 插入数据库
            insertOperLog(operLog);

        } catch (Exception e) {
            log.error("操作日志返回通知异常", e);
        } finally {
            // 清理线程局部变量
            operLogThreadLocal.remove();
        }
    }

    /**
     * 获取请求参数
     */
    private String getRequestParams(JoinPoint joinPoint, HttpServletRequest request) {
        Map<String, Object> params = new HashMap<>();

        // 添加基本请求信息
        params.put("url", request.getRequestURL().toString());
        params.put("method", request.getMethod());

        // 获取Query参数
        Map<String, String[]> parameterMap = request.getParameterMap();
        if (!parameterMap.isEmpty()) {
            Map<String, Object> queryParams = new HashMap<>();
            parameterMap.forEach((key, values) -> {
                if (values.length == 1) {
                    queryParams.put(key, values[0]);
                } else {
                    queryParams.put(key, values);
                }
            });
            params.put("query", queryParams);
        }

        // 获取Body参数（排除文件上传和响应对象）
        Object[] args = joinPoint.getArgs();
        if (args.length > 0) {
            for (Object arg : args) {
                if (isValidRequestBody(arg)) {
                    params.put("body", arg);
                    break; // 通常只有一个RequestBody
                }
            }
        }
        return JSON.toJSONString(params);
    }

    /**
     * 判断是否为有效的请求体参数
     */
    private boolean isValidRequestBody(Object arg) {
        return arg != null && !(arg instanceof HttpServletRequest) && !(arg instanceof HttpServletResponse)
            && !(arg instanceof MultipartFile) && !(arg instanceof MultipartFile[]);
    }

    /**
     * 插入操作日志到数据库
     */
    private void insertOperLog(SysOperLog operLog) {
        String username = SecurityUtils.getLoginUser().getUsername();
        String sql = "INSERT INTO sys_oper_log "
            + "(title,oper_time,method,request_method,oper_name,oper_url,oper_param,json_result,error_msg,cost_time) "
            + "VALUES (?, ?, ?,?, ?, ?, ?, ?,?, ?)";
        try {
            jdbcTemplate.update(sql, "OperLogAspect切面生成", operLog.getOperTime(), operLog.getMethod(),
                operLog.getRequestMethod(), username, operLog.getOperUrl(), operLog.getOperParam(),
                operLog.getJsonResult(), operLog.getErrorMsg(), operLog.getCostTime());
        } catch (Exception e) {
            log.error("插入操作日志失败", e);
        }
    }
}