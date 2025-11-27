package com.whale.framework.config;

import com.whale.framework.config.properties.PermitAllUrlProperties;
import com.whale.framework.security.filter.JwtAuthenticationTokenFilter;
import com.whale.framework.security.handle.AuthenticationEntryPointImpl;
import com.whale.framework.security.handle.LogoutSuccessHandlerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutFilter;
import org.springframework.web.filter.CorsFilter;

/**
 * Spring Security 配置（适配 Spring Boot 3.x + Spring Security 6.x）
 *
 * @author system
 */
@EnableMethodSecurity(
        prePostEnabled = true,  // 启用 @PreAuthorize/@PostAuthorize
        securedEnabled = true,  // 启用 @Secured
        jsr250Enabled = true    // 启用 JSR-250 注解（如 @RolesAllowed）
)
@Configuration
public class SecurityConfig {
    /**
     * 自定义用户认证逻辑（从数据库加载用户）
     */
    @Autowired
    private UserDetailsService userDetailsService;

    /**
     * 认证失败处理类（返回401）
     */
    @Autowired
    private AuthenticationEntryPointImpl unauthorizedHandler;

    /**
     * 退出成功处理类
     */
    @Autowired
    private LogoutSuccessHandlerImpl logoutSuccessHandler;

    /**
     * JWT Token 过滤器（验证Token有效性）
     */
    @Autowired
    private JwtAuthenticationTokenFilter authenticationTokenFilter;

    /**
     * 跨域过滤器
     */
    @Autowired
    private CorsFilter corsFilter;

    /**
     * 扫描@Anonymous注解的匿名URL配置
     */
    @Autowired
    private PermitAllUrlProperties permitAllUrlProperties;

    /**
     * 认证管理器（替换旧版 WebSecurityConfigurerAdapter）
     */
    @Bean
    public AuthenticationManager authenticationManager() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        // 配置用户加载逻辑
        provider.setUserDetailsService(userDetailsService);
        // 配置密码加密器（BCrypt强哈希）
        provider.setPasswordEncoder(bCryptPasswordEncoder());
        return new ProviderManager(provider);
    }

    /**
     * 过滤器链配置（核心：注入@Anonymous注解的白名单）
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                // 1. 禁用CSRF（前后端分离项目无需session）
                .csrf(csrf -> csrf.disable())
                // 2. 禁用缓存（避免静态资源缓存导致认证失效）
                .headers(headers -> headers
                        .cacheControl(cache -> cache.disable())
                        .frameOptions(frame -> frame.sameOrigin())  // 允许iframe同源访问
                )
                // 3. 认证失败处理（返回自定义401 JSON）
                .exceptionHandling(ex -> ex
                        .authenticationEntryPoint(unauthorizedHandler)
                )
                // 4. 无状态会话（基于Token，不创建session）
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                // 5. 权限控制（核心：注入@Anonymous注解的白名单）
                .authorizeHttpRequests(auth -> auth
                        // 5.1 允许@Anonymous注解的URL匿名访问
                        .requestMatchers(permitAllUrlProperties.getAnonymousUrls().toArray(new String[0])).permitAll()
                        // 5.2 允许静态资源匿名访问
                        .requestMatchers(HttpMethod.GET,
                                "/", "/*.html", "/**/*.html", "/**/*.css", "/**/*.js", "/profile/**"
                        ).permitAll()
                        // 5.3 其他所有请求必须认证
                        .anyRequest().authenticated()
                )
                // 6. 退出配置（自定义退出逻辑：删除Token、记录日志）
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessHandler(logoutSuccessHandler)
                        .clearAuthentication(true)
                )
                // 7. 过滤器顺序配置（关键：CORS→Token验证→Security认证）
                .addFilterBefore(corsFilter, LogoutFilter.class)          // 跨域过滤器最先执行
                .addFilterBefore(corsFilter, UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(authenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);  // Token过滤器在用户名密码过滤器前执行

        return http.build();
    }

    /**
     * BCrypt密码加密器（Spring Security 6.x推荐）
     */
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}