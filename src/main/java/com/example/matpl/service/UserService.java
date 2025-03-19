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

        if (!userDTO.getPassword().equals(userDTO.getPasswordCheck()))  {
            throw new UserAlreadyExistsException("비밀번호가 일치하지 않습니다.");
        }

        if (userDTO.getPassword().length() < 8) {
            throw new IllegalArgumentException("비밀번호는 최소 8자리 이상이어야 합니다.");
        }

        String encodedPassword = passwordEncoder.encode(userDTO.getPassword());


        UserEntity user = new UserEntity(
                userDTO.getEmail(),
                userDTO.getPassword(),
                userDTO.getPasswordCheck(),
                userDTO.getNickname()
        );

        userRepository.save(user);
        log.info("회원 저장 완료");
    }
}