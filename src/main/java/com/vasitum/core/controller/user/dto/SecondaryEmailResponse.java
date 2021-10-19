package com.vasitum.core.controller.user.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class SecondaryEmailResponse {
    private String userId;
    private List<SecondaryEmail> secondaryEmails;

    @Data
    @Builder
    public static class SecondaryEmail {
        private String email;
        private Boolean isVerified;
    }
}
