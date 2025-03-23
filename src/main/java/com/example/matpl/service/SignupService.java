package com.example.matpl.service;

import com.example.matpl.dto.UserDTO;
import com.example.matpl.entity.UserEntity;
import com.example.matpl.enums.UserStatus;
import com.example.matpl.repository.UserRepository;
import com.example.matpl.validator.DuplicateValidator;
import com.example.matpl.validator.PasswordValidator;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class SignupService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final MailService mailService;
    private final PasswordValidator passwordValidator;
    private final DuplicateValidator duplicateValidator;

    @Transactional
    public void signup(@Valid UserDTO userDTO) {
        duplicateValidator.emailValidate(userDTO.getEmail());
        duplicateValidator.nicknameValidate(userDTO.getNickname());
        passwordValidator.validate(userDTO.getPassword());

        String encodedPassword = passwordEncoder.encode(userDTO.getPassword());


        UserEntity user = UserEntity.builder()
                .email(userDTO.getEmail())
                .password(encodedPassword)
                .nickname(userDTO.getNickname())
                .status(UserStatus.UNVERIFIED)
                .build();

        userRepository.save(user);
        log.info("회원 저장 완료: {}", user.getEmail());

        mailService.sendSignupConfirmationEmail(user.getEmail());
    }
}