package com.vasitum.core.dao;

import com.vasitum.core.dao.model.SecondaryEmail;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SecondaryEmailRepository extends MongoRepository<SecondaryEmail, String> {
    List<SecondaryEmail> findByUserId(String userId);

    SecondaryEmail findByEmail(String email);
}
