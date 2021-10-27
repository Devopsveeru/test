package com.vasitum.core.controller.model;

import com.vasitum.core.controller.exception.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponse {
    private String message;
    private ErrorCode errorCode;
    private boolean error;
}
