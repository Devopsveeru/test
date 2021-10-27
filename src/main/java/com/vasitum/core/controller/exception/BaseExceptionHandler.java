package com.vasitum.core.controller.exception;

import com.vasitum.core.controller.model.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.nio.file.AccessDeniedException;

@Slf4j
@ControllerAdvice
public class BaseExceptionHandler {

    /**
     * catch-all for unhandled errors
     */
    @ExceptionHandler
    public ResponseEntity<BaseResponse> handleGenericException(Exception exception) {
        log.error("Unhandled error", exception);
        BaseResponse body = BaseResponse.builder()
                .error(true)
                .errorCode(ErrorCode.INTERNAL_SERVER_ERROR)
                .message("An unexpected error occurred")
                .build();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(body);
    }

    @ExceptionHandler(value = AccessDeniedException.class)
    public ResponseEntity<BaseResponse> handleAccessDenied() {
        log.info("Access not authorised");

        BaseResponse body = BaseResponse.builder()
                .error(true)
                .errorCode(ErrorCode.ACCESS_DENIED)
                .message("Access not authorised")
                .build();
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(body);
    }
}
