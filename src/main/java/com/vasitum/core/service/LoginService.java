package com.vasitum.core.service;

import com.vasitum.core.controller.login.dto.LoginRequest;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Slf4j
public class LoginService {

    @Value("${jwt.secret}")
    private String secret;

    public String authenticate(LoginRequest loginRequest) {
        log.info("Found user {}. Creating JWT token...", loginRequest.getUserName());
        Claims claims = Jwts.claims().setSubject("userId");
        claims.put("userId", "userId");
        claims.put("role", "candidate");
        claims.put("name", "name");
        claims.put("email", "email");

        return Jwts.builder().setSubject("userId")
                .setExpiration(new Date(System.currentTimeMillis() + 10000000))
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }
}
