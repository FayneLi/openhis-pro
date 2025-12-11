package com.whale.framework.config.properties;

import com.whale.common.annotation.Anonymous;
import org.apache.commons.lang3.RegExUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.*;
import java.util.regex.Pattern;

/**
 * 设置Anonymous注解允许匿名访问的url（适配Spring Boot 3.x）
 *
 * @author system
 */
@Configuration
public class PermitAllUrlProperties implements InitializingBean, ApplicationContextAware {
    // 匹配URL中的路径变量（如 /user/{id} → /user/*）
    private static final Pattern PATH_VARIABLE_PATTERN = Pattern.compile("\\{(.*?)\\}");
    // 替换符（将路径变量替换为*）
    private static final String PATH_VARIABLE_REPLACEMENT = "*";
    // Spring上下文
    private ApplicationContext applicationContext;
    // 存储匿名访问URL（去重）
    private final Set<String> anonymousUrls = new LinkedHashSet<>();

    @Override
    public void afterPropertiesSet() {
        // 获取Spring MVC的请求映射处理器
        RequestMappingHandlerMapping mapping = applicationContext.getBean(RequestMappingHandlerMapping.class);
        Map<RequestMappingInfo, HandlerMethod> handlerMethodMap = mapping.getHandlerMethods();

        // 遍历所有Controller方法，扫描Anonymous注解
        for (Map.Entry<RequestMappingInfo, HandlerMethod> entry : handlerMethodMap.entrySet()) {
            RequestMappingInfo requestMappingInfo = entry.getKey();
            HandlerMethod handlerMethod = entry.getValue();

            // 1. 扫描方法上的@Anonymous注解（优先级：方法注解 > 类注解）
            Anonymous methodAnonymous = AnnotationUtils.findAnnotation(handlerMethod.getMethod(), Anonymous.class);
            // 2. 扫描类上的@Anonymous注解
            Anonymous classAnonymous = AnnotationUtils.findAnnotation(handlerMethod.getBeanType(), Anonymous.class);

            // 若类或方法有@Anonymous注解，添加URL到白名单
            if (methodAnonymous != null || classAnonymous != null) {
                // 获取当前接口的所有URL模式（如 /api/login、/api/register）
                Set<String> urlPatterns = requestMappingInfo.getPatternsCondition().getPatterns();
                for (String url : urlPatterns) {
                    // 替换路径变量（如 /user/{id} → /user/*）
                    String normalizedUrl = RegExUtils.replaceAll(url, PATH_VARIABLE_PATTERN, PATH_VARIABLE_REPLACEMENT);
                    anonymousUrls.add(normalizedUrl);
                }
            }
        }

        // 手动添加框架默认匿名接口（避免注解遗漏）
        addDefaultAnonymousUrls();
    }

    /**
     * 添加框架默认匿名接口（如登录、注册、验证码）
     */
    private void addDefaultAnonymousUrls() {
        anonymousUrls.addAll(Arrays.asList(
                "/login", "/register", "/captchaImage","/test",
                "/swagger-ui/**", "/v3/api-docs/**", "/webjars/**",
                "/patientmanage/information/**"
        ));
    }

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        this.applicationContext = context;
    }

    /**
     * 对外提供匿名URL列表（供Security配置使用）
     */
    public List<String> getAnonymousUrls() {
        return new ArrayList<>(anonymousUrls);
    }
}