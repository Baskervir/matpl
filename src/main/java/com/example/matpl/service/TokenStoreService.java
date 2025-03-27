package com.example.matpl.service;

import com.example.matpl.dto.UserDTO;
import com.example.matpl.entity.EmailVerificationToken;
import com.example.matpl.repository.EmailVerificationTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TokenStoreService {
    private final EmailVerificationTokenRepository tokenRepository;

    @Transactional
    public void insertVerificationData(UserDTO userDTO, String createdToken) {
        EmailVerificationToken verifyData = EmailVerificationToken.builder()
                .email(userDTO.getEmail())
                .token(createdToken)
                .expireDate(LocalDateTime.now().plusMinutes(10))
                .verified(false)
                .build();

        tokenRepository.save(verifyData);
    }
}
