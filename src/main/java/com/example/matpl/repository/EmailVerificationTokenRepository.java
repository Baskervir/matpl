package com.example.matpl.repository;

import com.example.matpl.entity.EmailVerificationToken;

public interface EmailVerificationTokenRepository {

    void save(EmailVerificationToken entity);
}
