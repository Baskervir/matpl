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

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public void registerUser(String userEmail, String password) {
        if (userRepository.existsByUserEmail(userEmail)) {
            throw new UserAlreadyExistsException("이미 존재하는 사용자입니다.");
        }

        String encodedPassword = passwordEncoder.encode(password);
        UserEntity user = new UserEntity(userEmail, encodedPassword);

        userRepository.save(user);
    }
}
