package com.vasitum.core.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Api
@Slf4j
@RestController
@RequestMapping("/healthcheck")
public class HealthCheckController {

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    @ApiOperation("Get the service health check status")
    public HealthCheckResponse getResponse() {
        return new HealthCheckResponse("UP");
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class HealthCheckResponse {
        private String status;
    }
}
