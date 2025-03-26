package com.example.matpl.usecase;

import com.example.matpl.entity.EmailVerificationToken;
import com.example.matpl.exception.TokenException;
import com.example.matpl.repository.EmailVerificationTokenRepository;
import com.example.matpl.service.CheckExpireTimeService;
import com.example.matpl.service.TokenMatchingService;
import com.example.matpl.service.VerificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SignupVerifyUserUseCase {
    private final TokenMatchingService tokenMatchingService;
    private final CheckExpireTimeService checkExpireTimeService;
    private final VerificationService verificationService;
    private final EmailVerificationTokenRepository tokenRepository;

    public void execute(String token) {
        EmailVerificationToken tokenEntity = tokenRepository.findByToken(token)
                .orElseThrow(() -> new TokenException("토큰이 존재하지 않습니다."));

        tokenMatchingService.matchToken(tokenEntity, token);
        checkExpireTimeService.checkExpireTime(tokenEntity);
        verificationService.confirm(tokenEntity);
    }
}
