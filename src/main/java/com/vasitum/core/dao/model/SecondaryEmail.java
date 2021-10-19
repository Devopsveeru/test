package com.vasitum.core.dao.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Document
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SecondaryEmail {
    @Id
    private String id;
    @NotNull
    private String userId;
    @NotNull
    @Indexed(unique = true)
    private String email;
    private boolean isVerified;
    private boolean isDeleted;
    private OtpDetails otp;
    private long createDate;
    private long updateDate;

    @Data
    public static class OtpDetails {
        private String otp;
        private long expireIn;
    }
}
