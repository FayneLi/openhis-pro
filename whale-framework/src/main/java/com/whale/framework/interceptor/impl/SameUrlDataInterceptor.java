package com.whale.framework.interceptor.impl;

import com.alibaba.fastjson2.JSON;
import com.whale.common.annotation.RepeatSubmit;
import com.whale.common.constant.CacheConstants;
import com.whale.common.core.redis.RedisCache;
import com.whale.common.filter.RepeatedlyRequestWrapper;
import com.whale.common.utils.StringUtils;
import com.whale.common.utils.http.HttpHelper;
import com.whale.framework.config.properties.PermitAllUrlProperties;
import com.whale.framework.interceptor.RepeatSubmitInterceptor;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 重复提交拦截器（适配匿名接口Token为空场景）
 *
 * @author system
 */
@Component
public class SameUrlDataInterceptor extends RepeatSubmitInterceptor {
    public static final String REPEAT_PARAMS = "repeatParams";
    public static final String REPEAT_TIME = "repeatTime";

    // Token请求头（匿名接口可能为空）
    @Value("${token.header}")
    private String tokenHeader;

    @Autowired
    private RedisCache redisCache;

    /**
     * 注入匿名URL配置（匿名接口跳过重复提交校验）
     */
    @Autowired
    private PermitAllUrlProperties permitAllUrlProperties;

    @Override
    public boolean isRepeatSubmit(HttpServletRequest request, RepeatSubmit annotation) {
        // 1. 匿名接口直接跳过重复提交校验（避免Token为空导致的异常）
        String requestUrl = request.getRequestURI();
        if (permitAllUrlProperties.getAnonymousUrls().contains(requestUrl)) {
            return false;  // 不拦截匿名接口
        }

        // 2. 非匿名接口：正常校验重复提交（原有逻辑保留）
        String nowParams = "";
        if (request instanceof RepeatedlyRequestWrapper) {
            RepeatedlyRequestWrapper repeatedlyRequest = (RepeatedlyRequestWrapper) request;
            nowParams = HttpHelper.getBodyString(repeatedlyRequest);
        }

        // 3. 处理参数为空的场景（获取URL参数）
        if (StringUtils.isEmpty(nowParams)) {
            nowParams = JSON.toJSONString(request.getParameterMap());
        }

        // 4. 构建缓存Key（适配匿名用户：Token为空时用IP+URL作为Key）
        Map<String, Object> nowDataMap = new HashMap<>();
        nowDataMap.put(REPEAT_PARAMS, nowParams);
        nowDataMap.put(REPEAT_TIME, System.currentTimeMillis());

        // 请求URL（作为缓存Key的一部分）
        String url = request.getRequestURI();
        // Token（匿名用户为空，用IP替代）
        String token = StringUtils.trimToEmpty(request.getHeader(tokenHeader));
        String submitKey = StringUtils.isEmpty(token) ? getClientIp(request) : token;

        // 最终缓存Key（匿名用户：IP+URL；登录用户：Token+URL）
        String cacheKey = CacheConstants.REPEAT_SUBMIT_KEY + url + "_" + submitKey;

        // 5. 重复提交判断（原有逻辑保留）
        Object cacheObj = redisCache.getCacheObject(cacheKey);
        if (cacheObj != null) {
            Map<String, Object> preDataMap = (Map<String, Object>) cacheObj;
            if (compareParams(nowDataMap, preDataMap) && compareTime(nowDataMap, preDataMap, annotation.interval())) {
                return true;  // 是重复提交
            }
        }

        // 6. 缓存当前请求参数（设置过期时间）
        redisCache.setCacheObject(cacheKey, nowDataMap, annotation.interval(), TimeUnit.MILLISECONDS);
        return false;
    }

    /**
     * 获取客户端IP（适配匿名用户）
     */
    private String getClientIp(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    /**
     * 比较参数是否相同（原有逻辑保留）
     */
    private boolean compareParams(Map<String, Object> nowMap, Map<String, Object> preMap) {
        String nowParams = (String) nowMap.get(REPEAT_PARAMS);
        String preParams = (String) preMap.get(REPEAT_PARAMS);
        return nowParams.equals(preParams);
    }

    /**
     * 比较时间间隔是否小于阈值（原有逻辑保留）
     */
    private boolean compareTime(Map<String, Object> nowMap, Map<String, Object> preMap, int interval) {
        long time1 = (Long) nowMap.get(REPEAT_TIME);
        long time2 = (Long) preMap.get(REPEAT_TIME);
        return (time1 - time2) < interval;
    }
}