package com.vasitum.core.config;

import com.vasitum.core.config.bean.UserInfoService;
import com.vasitum.core.exception.InvalidAuthTokenException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.MDC;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
@Order(1)
@Slf4j
public class AuthInterceptor implements HandlerInterceptor {

    private final Pattern authPattern = Pattern.compile("Bearer\\s(.*)");

    @Resource
    private UserInfoService userInfoService;

    @Resource
    private ApplicationContext applicationContext;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        this.userInfoService = applicationContext.getBean(UserInfoService.class);
        try {
            String authToken = request.getHeader("Authorization");
            if (StringUtils.isBlank(authToken)) {
                throw new InvalidAuthTokenException("No authorization token received");
            }
            Matcher m = authPattern.matcher(authToken);
            if (!m.find()) {
                throw new InvalidAuthTokenException("Invalid authorization token");
            }

            String mdcData = String.format("[requestId:%s|user:%s] ", UUID.randomUUID(), "userId");
            MDC.put("mdcData", mdcData);

            UserDetails userDetails = new AuthorizedUser("userId", "candidate");
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);

            return true;
        } catch (Exception e) {
            authenticationFailed(response, e.getMessage());
        } finally {
            MDC.clear();
        }
        return false;
    }

    private void authenticationFailed(HttpServletResponse response, String reason) throws IOException {
        String mdcData = String.format("[requestId:%s] ", UUID.randomUUID());
        MDC.put("mdcData", mdcData);
        log.warn("Auth Failed Reason: " + reason);
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, reason);
    }
}
