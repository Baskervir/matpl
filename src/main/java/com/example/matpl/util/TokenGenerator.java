package com.example.matpl.util;

import com.example.matpl.entity.EmailVerificationToken;
import com.example.matpl.repository.EmailVerificationTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TokenGenerator {
    private final EmailVerificationTokenRepository repository;

    public static String generate() {
        return UUID.randomUUID().toString();
    }

    public void insertVerificationData(EmailVerificationToken dto) {
        EmailVerificationToken target = EmailVerificationToken.builder()
                .email(dto.getEmail())
                .token(dto.getToken())
                .expireDate(dto.getExpireDate())
                .verified(false)
                .build();
    }
}
