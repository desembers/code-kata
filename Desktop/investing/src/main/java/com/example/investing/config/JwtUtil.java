package com.example.investing.config;

import com.example.investing.domain.common.exception.ServerException;
import com.example.investing.domain.user.enums.UserRule;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.annotation.PostConstruct;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.security.Key;
import java.security.Signature;
import java.util.Base64;
import java.util.Date;

@Slf4j(topic= "JwtUtil")
public class JwtUtil {

    private static String BEARER_PREFIX = "Bearer ";
    private static long TOKEN_TIME = 60 * 60 * 1000;

    @Value("${jwt.secret.key}")
    private String securitykey;
    private Key key;
    private final SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

    @PostConstruct
    public void init() {
        byte[] bytes = Base64.getDecoder().decode(securitykey);
        key = keys.hamcShakeyFor(bytes);
    }

    public String createToken(Long userId, String email, UserRule uerRule) {
        Date date = new Date();

        return BEARER_PREFIX + Jwts.builder()
                .setSubject(String.valueOf(userId))
                .claim("email", email)
                .claim("userRule", uerRule)
                .setExpiration(new Date(date.getTime() + TOKEN_TIME))
                .setIssuedAt(date) //발급입
                .signWith(key, signatureAlgorithm) //암호화 알고리즘
                .compact();
    }

    public String substringToken(String tokenValue) {
        if (StringUtils.hasText(tokenValue) && tokenValue.startsWith(BEARER_PREFIX)) {
            return tokenValue.substring(7);
        }
        throw new ServerException("유저가 발견되지 않았습니다");
    }

    public Claims extractClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }



}
