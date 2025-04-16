package com.example.matpl.login.service;

import com.example.matpl.entity.UserEntity;
import com.example.matpl.exception.DisableLoginException;
import com.example.matpl.login.domain.UserInfo;
import com.example.matpl.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailCheckService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserInfo findUserInfoByEmail(String email) {
        UserEntity user = userRepository.findByEmail(email)
                .orElseThrow(() -> new DisableLoginException("이메일 또는 비밀번호가 일치하지 않습니다."));
        return new UserInfo(user.getEmail(), user.getNickname(), user.getPassword());
    }
}
