package com.vasitum.core.controller.user;

import com.vasitum.core.controller.user.dto.SecondaryEmailResponse;
import com.vasitum.core.service.SecondaryEmailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Api
@Slf4j
@RestController
@RequestMapping("/api/v1/secondaryEmail")
public class SecondaryEmailController {

    @Resource
    private SecondaryEmailService secondaryEmailService;

    @GetMapping(value = "/all", produces = APPLICATION_JSON_VALUE)
    @ApiOperation("Get the list of all secondary emails")
    public ResponseEntity<SecondaryEmailResponse> getSecondaryEmails() {
        SecondaryEmailResponse response = secondaryEmailService.getSecondaryEmails("61017ab098dd1565471f9b94");
        log.info("Secondary emails successfully fetched");
        return ResponseEntity.ok().body(response);
    }
}
