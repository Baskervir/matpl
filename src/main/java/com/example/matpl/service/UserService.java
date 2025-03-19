package com.example.matpl.service;

import com.example.matpl.Role;
import com.example.matpl.dto.UserDTO;
import com.example.matpl.entity.UserEntity;
import com.example.matpl.exception.UserAlreadyExistsException;
import com.example.matpl.repository.UserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Transactional
    public void registerUser(@Valid UserDTO userDTO) {
        if (userRepository.existsByEmail(userDTO.getEmail())) {
            throw new UserAlreadyExistsException("이미 사용 중인 이메일입니다.");
        }

        if (userRepository.existsByNickname(userDTO.getNickname())) {
            throw new UserAlreadyExistsException("이미 사용 중인 닉네임입니다.");
        }

        if (userRepository.existsByPassword(userDTO.getPassword())) {
            throw new UserAlreadyExistsException("비밀번호가 일치하지 않습니다.");
        }

        String encodedPassword = passwordEncoder.encode(userDTO.getPassword());

        log.info("UserEntity 생성 전 - email: {}, nickname: {}", userDTO.getEmail(), userDTO.getNickname());

        UserEntity user = new UserEntity(
                userDTO.getEmail(),
                userDTO.getPassword(),
                userDTO.getPasswordCheck(),
                userDTO.getNickname()
        );

        log.info("UserEntity 생성 완료: {}", user);

        userRepository.save(user);
        log.info(userRepository.toString());
        log.info("회원 저장 완료");
    }
}