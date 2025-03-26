package com.example.matpl.service;

import com.example.matpl.entity.EmailVerificationToken;
import com.example.matpl.exception.TokenException;
import com.example.matpl.repository.EmailVerificationTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TokenMatchingService {
    private final EmailVerificationTokenRepository tokenRepository;

    public void matchToken(EmailVerificationToken tokenEntity, String token) {
        if (!tokenEntity.getToken().equals(token)) {
            throw new TokenException("토큰이 일치하지 않습니다.");
        }
    }
}
