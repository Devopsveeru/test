package com.vasitum.core.mapper;

import com.vasitum.core.controller.user.dto.SecondaryEmailResponse;
import com.vasitum.core.dao.model.SecondaryEmail;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
public class SecondaryEmailMapper {

    public List<SecondaryEmailResponse.SecondaryEmail> map(List<SecondaryEmail> emails) {
        return emails.stream()
                .map(s -> SecondaryEmailResponse.SecondaryEmail.builder()
                        .email(s.getEmail())
                        .isVerified(s.isVerified())
                        .build())
                .collect(toList());
    }
}
