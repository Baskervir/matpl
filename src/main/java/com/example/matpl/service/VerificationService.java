package com.example.matpl.service;

import com.example.matpl.entity.EmailVerificationToken;
import com.example.matpl.entity.UserEntity;
import com.example.matpl.exception.UserNotFoundException;
import com.example.matpl.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class VerificationService {
    private final UserRepository userRepository;

    public void confirm(EmailVerificationToken tokenEntity) {
        tokenEntity.markAsVerified();

        UserEntity user = userRepository.findByEmail(tokenEntity.getEmail())
                .orElseThrow(() -> new UserNotFoundException("사용자를 찾을 수 없습니다."));

        user.verifiedUser();
    }
}