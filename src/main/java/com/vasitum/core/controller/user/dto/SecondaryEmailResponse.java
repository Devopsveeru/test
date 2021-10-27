package com.vasitum.core.controller.user.dto;

import com.vasitum.core.controller.model.BaseResponse;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
public class SecondaryEmailResponse extends BaseResponse {
    private String userId;
    private List<SecondaryEmail> secondaryEmails;

    @Data
    @Builder
    public static class SecondaryEmail {
        private String email;
        private Boolean isVerified;
    }
}
