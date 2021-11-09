package com.vasitum.core.controller.login;

import com.vasitum.core.controller.login.dto.LoginRequest;
import com.vasitum.core.controller.login.dto.LoginResponse;
import com.vasitum.core.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Api
@Slf4j
@RestController
@RequestMapping("/api/v1/login")
public class LoginController {

    @Resource
    private LoginService loginService;

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    @ApiOperation("To login user and provide token")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        String token = loginService.authenticate(request);
        log.info("Auth token generated");
        return ResponseEntity.ok().body(LoginResponse.builder().token(token).build());
    }
}
