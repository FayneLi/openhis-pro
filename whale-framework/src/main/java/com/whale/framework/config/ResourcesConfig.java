package com.whale.framework.config;

import com.whale.common.config.CoreConfig;
import com.whale.common.constant.Constants;
import com.whale.framework.config.properties.PermitAllUrlProperties;
import com.whale.framework.interceptor.RepeatSubmitInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.concurrent.TimeUnit;

/**
 * 资源与拦截器配置（适配匿名接口排除）
 *
 * @author system
 */
@Configuration
public class ResourcesConfig implements WebMvcConfigurer {
    @Autowired
    private RepeatSubmitInterceptor repeatSubmitInterceptor;

    /**
     * 注入匿名URL配置（排除重复提交拦截）
     */
    @Autowired
    private PermitAllUrlProperties permitAllUrlProperties;

    /**
     * 静态资源映射（如上传文件、Swagger）
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 本地文件上传路径（如 /profile/xxx → 映射到服务器本地目录）
        registry.addResourceHandler(Constants.RESOURCE_PREFIX + "/**")
                .addResourceLocations("file:" + CoreConfig.getProfile() + "/")
                .setCacheControl(CacheControl.maxAge(1, TimeUnit.HOURS).cachePublic());

        // Swagger3资源映射（避免404）
        registry.addResourceHandler("/swagger-ui/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/springfox-swagger-ui/")
                .setCacheControl(CacheControl.maxAge(5, TimeUnit.HOURS).cachePublic());
    }

    /**
     * 拦截器配置（核心：排除@Anonymous注解的匿名接口）
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(repeatSubmitInterceptor)
                .addPathPatterns("/**")  // 拦截所有请求
                // 排除@Anonymous注解的匿名接口（避免重复提交拦截匿名接口）
                .excludePathPatterns(permitAllUrlProperties.getAnonymousUrls());
    }
}