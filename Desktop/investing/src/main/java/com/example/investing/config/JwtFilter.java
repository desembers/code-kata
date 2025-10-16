package com.example.investing.config;


import com.example.investing.domain.auth.exception.AuthException;
import com.example.investing.domain.common.dto.AuthUser;
import com.example.investing.domain.user.enums.UserRule;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.micrometer.common.lang.Nullable;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.Filter;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
public class JwtFilter implements Filter {

    private JwtUtil jwtUtil;
    private ObjectMapper objectMapper;

    @Override
    public void doFilter(
       ServletRequest request, ServletResponse response, FilterChain chain
    ) throws IOException, ServletException {
        HttpServletRequest httprequest = (HttpServletRequest) request;
        HttpServletResponse httpresponse = (HttpServletResponse) response;

        String url = httprequest.getRequestURL();

        if(url.startsWith("/auth")) {
            chain.doFilter(httprequest, httpresponse);
            return;
        }

        String bearerJwt = httprequest.getHeader("Authorization");
        if(bearerJwt == null) {
            log.warn("인증 헤더 누락: URI={}", url);
            sendErrorResponse(httpresponse, HttpStatus.UNAUTHORIZED, "인증이 필요합니다.");
            return;
        }

        try {
            // JWT 유효성 검사와 claims 추출
            Claims claims = jwtUtil.extractClaims(jwt);
            if (claims == null) {
                log.warn("Claims 추출 실패: URI={}", url);
                sendErrorResponse(httpResponse, HttpStatus.UNAUTHORIZED, "인증이 필요합니다.");
                return;
            }

            UserRole userRole = UserRole.valueOf(claims.get("userRole", String.class));

            httpRequest.setAttribute("userId", Long.parseLong(claims.getSubject()));
            httpRequest.setAttribute("email", claims.get("email"));
            httpRequest.setAttribute("userRole", claims.get("userRole"));

            if (url.startsWith("/admin") && !UserRole.ADMIN.equals(userRole)) {
                log.warn("권한 부족: userId={}, role={}, URI={}", claims.getSubject(), userRole, url);
                sendErrorResponse(httpResponse, HttpStatus.FORBIDDEN, "접근 권한이 없습니다.");
                return;
            }

            chain.doFilter(request, response);
        } catch (ExpiredJwtException e) {
            log.info("JWT 만료: userId={}, URI={}", e.getClaims().getSubject(), url);
            sendErrorResponse(httpResponse, HttpStatus.UNAUTHORIZED, "인증이 필요합니다.");
        } catch (SecurityException | MalformedJwtException | UnsupportedJwtException e) {
            log.error("JWT 검증 실패 [{}]: URI={}", e.getClass().getSimpleName(), url, e);
            sendErrorResponse(httpResponse, HttpStatus.BAD_REQUEST, "인증이 필요합니다.");
        } catch (Exception e) {
            log.error("예상치 못한 오류: URI={}", url, e);
            sendErrorResponse(httpResponse, HttpStatus.INTERNAL_SERVER_ERROR, "요청 처리 중 오류가 발생했습니다.");
        }
    }

    private void sendErrorResponse(HttpServletResponse response, HttpStatus status, String message) throws IOException {
        response.setStatus(status.value());
        response.setContentType("application/json;charset=UTF-8");

        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("status", status.name());
        errorResponse.put("code", status.value());
        errorResponse.put("message", message);

        response.getWriter().write(objectMapper.writeValueAsString(errorResponse));
    }
}
public class AuthUserArgumentResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        boolean hasAuthAnnotation = parameter.getParameterAnnotation(Auth.class) != null;
        boolean isAuthUserType = parameter.getParameterType().equals(AuthUser.class);

        // @Auth 어노테이션과 AuthUser 타입이 함께 사용되지 않은 경우 예외 발생
        if (hasAuthAnnotation != isAuthUserType) {
            throw new AuthException("@Auth와 AuthUser 타입은 함께 사용되어야 합니다.");
        }

        return hasAuthAnnotation;
    }

    @Override
    public Object resolveArgument(
            @Nullable MethodParameter parameter,
            @Nullable ModelAndViewContainer mavContainer,
            NativeWebRequest webRequest,
            @Nullable WebDataBinderFactory binderFactory
    ) {
        HttpServletRequest request = (HttpServletRequest) webRequest.getNativeRequest();

        // JwtFilter 에서 set 한 userId, email, userRole 값을 가져옴
        Long userId = (Long) request.getAttribute("userId");
        String email = (String) request.getAttribute("email");
        UserRule userRole = UserRule.of((String) request.getAttribute("userRole"));

        return new AuthUser(userId, email, userRole);
    }



}

}
