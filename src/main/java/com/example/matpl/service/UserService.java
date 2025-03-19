package com.example.matpl.service;

import com.example.matpl.DTO.UserDTO;
import com.example.matpl.entity.UserEntity;
import com.example.matpl.exception.UserAlreadyExistsException;
import com.example.matpl.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Transactional
    public void registerUser(UserDTO userDTO) {

        if (userRepository.existsByUserEmail(userDTO.getEmail())) {
            throw new UserAlreadyExistsException("이미 사용 중인 이메일입니다.");
        }

        if (userRepository.existsByUserNickname(userDTO.getNickname())) {
            throw new UserAlreadyExistsException("이미 사용 중인 닉네임입니다.");
        }

        if (!userDTO.getPassword().equals(userDTO.getPasswordCheck())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        String encodedPassword = passwordEncoder.encode(userDTO.getPassword());

        UserEntity user = new UserEntity(
                null,
                userDTO.getEmail(),
                encodedPassword,
                userDTO.getNickname(),
                null
        );

        userRepository.save(user);
    }
}