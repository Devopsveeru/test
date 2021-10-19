package com.vasitum.core.service;

import com.vasitum.core.controller.user.dto.SecondaryEmailResponse;
import com.vasitum.core.dao.SecondaryEmailRepository;
import com.vasitum.core.dao.model.SecondaryEmail;
import com.vasitum.core.exception.ResourceNotFoundException;
import com.vasitum.core.mapper.SecondaryEmailMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class SecondaryEmailService {

    @Resource
    private SecondaryEmailRepository secondaryEmailRepository;

    @Resource
    private SecondaryEmailMapper secondaryEmailMapper;

    public SecondaryEmailResponse getSecondaryEmails(String userId) {
        List<SecondaryEmail> secondaryEmails = secondaryEmailRepository.findByUserId(userId);
        if (!secondaryEmails.isEmpty()) {
            List<SecondaryEmailResponse.SecondaryEmail> emails = secondaryEmailMapper.map(secondaryEmails);
            return SecondaryEmailResponse.builder().userId(userId).secondaryEmails(emails).build();
        }
        throw new ResourceNotFoundException("Secondary emails not exist");
    }
}
