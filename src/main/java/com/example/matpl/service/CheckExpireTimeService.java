package com.example.matpl.service;

import com.example.matpl.entity.EmailVerificationToken;
import com.example.matpl.repository.EmailVerificationTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CheckExpireTimeService {
    private EmailVerificationTokenRepository tokenRepository;

    public void checkExpireTime(EmailVerificationToken tokenEntity) {
        if (tokenEntity.getExpireDate().isBefore(LocalDateTime.now())) {
            throw new IllegalStateException("인증 시간이 만료되었습니다.");
        }
    }
}
