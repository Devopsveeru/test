package com.vasitum.core.controller.login.dto;

import com.vasitum.core.controller.model.BaseResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class LoginResponse extends BaseResponse {
    private String token;
}
