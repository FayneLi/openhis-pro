package com.whale.framework.web.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.whale.common.constant.CacheConstants;
import com.whale.common.constant.Constants;
import com.whale.common.core.domain.model.LoginUser;
import com.whale.common.core.redis.RedisCache;
import com.whale.common.utils.StringUtils;
import com.whale.common.utils.uuid.IdUtils;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * token验证处理（适配JJWT 0.13.0版本）
 *
 * @author system
 */
@Component
public class TokenService {
    protected static final long MILLIS_SECOND = 1000;
    protected static final long MILLIS_MINUTE = 60 * MILLIS_SECOND;
    private static final Logger log = LoggerFactory.getLogger(TokenService.class);
    // 令牌剩余有效期不足20分钟时自动刷新
    private static final Long MILLIS_MINUTE_TEN = 20 * 60 * 1000L;

    // 令牌自定义标识（从配置文件读取，如：Authorization）
    @Value("${token.header}")
    private String header;

    // 令牌秘钥（从配置文件读取，需确保长度≥32字节，适配HS512算法）
    @Value("${token.secret}")
    private String secret;

    // 令牌有效期（默认30分钟，从配置文件读取）
    @Value("${token.expireTime}")
    private int expireTime;

    @Autowired
    private RedisCache redisCache;

    // 基于配置的secret生成JJWT 0.13.0要求的Key对象（HS512算法专用）
    private Key getSigningKey() {
        byte[] keyBytes = secret.getBytes(StandardCharsets.UTF_8);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    /**
     * 获取用户身份信息（完全保留原逻辑）
     *
     * @return 用户信息
     */
    public LoginUser getLoginUser(HttpServletRequest request) {
        // 获取请求携带的令牌
        String token = getToken(request);
        if (StringUtils.isNotEmpty(token)) {
            try {
                Claims claims = parseToken(token);
                // 解析对应的权限以及用户信息
                String uuid = (String) claims.get(Constants.LOGIN_USER_KEY);
                String userKey = getTokenKey(uuid);
                LoginUser user = redisCache.getCacheObject(userKey);
                return user;
            } catch (Exception e) {
                log.error("获取用户信息异常: {}", e.getMessage());
            }
        }
        return null;
    }

    /**
     * 设置用户身份信息（完全保留原逻辑）
     */
    public void setLoginUser(LoginUser loginUser) {
        if (StringUtils.isNotNull(loginUser) && StringUtils.isNotEmpty(loginUser.getToken())) {
            refreshToken(loginUser);
        }
    }

    /**
     * 删除用户身份信息（完全保留原逻辑）
     */
    public void delLoginUser(String token) {
        if (StringUtils.isNotEmpty(token)) {
            String userKey = getTokenKey(token);
            redisCache.deleteObject(userKey);
        }
    }

    /**
     * 创建令牌（适配JJWT 0.13.0的builder API）
     *
     * @param loginUser 用户信息
     * @return 令牌
     */
    public String createToken(LoginUser loginUser) {
        String token = IdUtils.fastUUID();
        loginUser.setToken(token);
        //setUserAgent(loginUser);
        refreshToken(loginUser);

        // 构建JWT的Claims（保留原逻辑：仅存储LOGIN_USER_KEY=uuid）
        Map<String, Object> claims = new HashMap<>();
        claims.put(Constants.LOGIN_USER_KEY, token);

        // 适配JJWT 0.13.0：使用builder() + signWith(Key, Algorithm)
        return Jwts.builder()
                .setClaims(claims)
                .signWith(getSigningKey(), SignatureAlgorithm.HS512) // 显式指定算法+Key
                .compact();
    }

    /**
     * 验证令牌有效期，相差不足20分钟自动刷新缓存（完全保留原逻辑）
     *
     * @param loginUser 用户信息
     */
    public void verifyToken(LoginUser loginUser) {
        long expireTime = loginUser.getExpireTime();
        long currentTime = System.currentTimeMillis();
        if (expireTime - currentTime <= MILLIS_MINUTE_TEN) {
            refreshToken(loginUser);
        }
    }

    /**
     * 刷新令牌有效期（完全保留原逻辑）
     *
     * @param loginUser 登录信息
     */
    public void refreshToken(LoginUser loginUser) {
        loginUser.setLoginTime(System.currentTimeMillis());
        loginUser.setExpireTime(loginUser.getLoginTime() + expireTime * MILLIS_MINUTE);
        // 根据uuid将loginUser缓存到Redis
        String userKey = getTokenKey(loginUser.getToken());
        redisCache.setCacheObject(userKey, loginUser, expireTime, TimeUnit.MINUTES);
    }

    /**
     * 设置用户代理信息（补充UserAgent依赖说明，逻辑不变）
     *
     * @param loginUser 登录信息
     */
//    public void setUserAgent(LoginUser loginUser) {
//        // 注意：需确保项目依赖 eu.bitwalker:useragentutils 包（原代码依赖，此处保留）
//        UserAgent userAgent = UserAgent.parseUserAgentString(ServletUtils.getRequest().getHeader("User-Agent"));
//        String ip = IpUtils.getIpAddr();
//        loginUser.setIpaddr(ip);
//        loginUser.setLoginLocation(AddressUtils.getRealAddressByIP(ip));
//        loginUser.setBrowser(userAgent.getBrowser().getName());
//        loginUser.setOs(userAgent.getOperatingSystem().getName());
//    }

    /**
     * 从令牌中获取数据声明（适配JJWT 0.13.0的parserBuilder API）
     *
     * @param token 令牌
     * @return 数据声明
     */
    private Claims parseToken(String token) {
        try {
            return Jwts.parser()
                    .setSigningKey(getSigningKey()) // 绑定签名Key
                    .build() // 构建Parser
                    .parseClaimsJws(token) // 解析JWT
                    .getBody(); // 获取Claims
        } catch (SignatureException e) {
            log.error("JWT签名验证失败: {}", e.getMessage());
            throw e;
        } catch (Exception e) {
            log.error("JWT令牌解析异常: {}", e.getMessage());
            throw e;
        }
    }

    /**
     * 从令牌中获取用户名（原逻辑不变，依赖parseToken方法）
     *
     * @param token 令牌
     * @return 用户名
     */
    public String getUsernameFromToken(String token) {
        Claims claims = parseToken(token);
        // 注意：原代码中JWT未存储Subject（用户名），若需此功能，需在createToken时添加setSubject(loginUser.getUsername())
        return claims.getSubject();
    }

    /**
     * 获取请求中的token（完全保留原逻辑）
     *
     * @param request 请求对象
     * @return token
     */
    private String getToken(HttpServletRequest request) {
        String token = request.getHeader(header);
        if (StringUtils.isNotEmpty(token) && token.startsWith(Constants.TOKEN_PREFIX)) {
            // 移除令牌前缀（如：Bearer ）
            token = token.replace(Constants.TOKEN_PREFIX, "");
        }
        return token;
    }

    /**
     * 生成Redis中的token缓存Key（完全保留原逻辑）
     */
    private String getTokenKey(String uuid) {
        return CacheConstants.LOGIN_TOKEN_KEY + uuid;
    }
}