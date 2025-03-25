package com.example.matpl.service;

import com.example.matpl.entity.EmailVerificationToken;
import com.example.matpl.repository.EmailVerificationTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TokenStoreService {
    private final EmailVerificationTokenRepository tokenRepository;

    public void insertVerificationData(EmailVerificationToken dto) {
        EmailVerificationToken target = EmailVerificationToken.builder()
                .email(dto.getEmail())
                .token(dto.getToken())
                .expireDate(dto.getExpireDate())
                .verified(false)
                .build();
        tokenRepository.save(target);
    }
}
