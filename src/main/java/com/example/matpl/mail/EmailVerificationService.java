package com.example.matpl.mail;

import com.example.matpl.entity.EmailVerificationToken;
import com.example.matpl.repository.EmailVerificationTokenRepository;
import com.example.matpl.util.TokenGenerator;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EmailVerificationService {
    private EmailVerificationTokenRepository tokenRepository;

    public String generateAndSaveToken(String email) {
        String token = TokenGenerator.generate();
        LocalDateTime expiry = LocalDateTime.now().plusMinutes(10);

        EmailVerificationToken entity = new EmailVerificationToken(
                null, token, email, expiry, false
        );

        tokenRepository.save(entity);

        return token;
    }
}
