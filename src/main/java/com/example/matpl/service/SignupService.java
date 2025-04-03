package com.example.matpl.service;

import com.example.matpl.dto.UserDTO;
import com.example.matpl.entity.UserEntity;
import com.example.matpl.enums.Role;
import com.example.matpl.enums.UserStatus;
import com.example.matpl.repository.UserRepository;
import com.example.matpl.validator.DuplicateUserInfoValidator;
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
    private final PasswordValidator passwordValidator;
    private final DuplicateUserInfoValidator duplicateUserInfoValidator;

    @Transactional
    public void signup(@Valid UserDTO userDTO) {
        duplicateUserInfoValidator.emailValidate(userDTO.getEmail());
        duplicateUserInfoValidator.nicknameValidate(userDTO.getNickname());
        passwordValidator.validate(userDTO.getPassword(), userDTO.getPasswordCheck());

        String encodedPassword = passwordEncoder.encode(userDTO.getPassword());

        UserEntity user = UserEntity.builder()
                .email(userDTO.getEmail())
                .password(encodedPassword)
                .nickname(userDTO.getNickname())
                .role(Role.BASIC)
                .status(UserStatus.UNVERIFIED)
                .build();

        userRepository.save(user);
    }
}