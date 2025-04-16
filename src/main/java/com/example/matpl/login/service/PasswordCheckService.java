package com.example.matpl.login.service;

import com.example.matpl.exception.DisableLoginException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PasswordCheckService {
    private final BCryptPasswordEncoder passwordEncoder;

    public void passwordCheck(String rawPassword, String encodedPassword) {
        if (!passwordEncoder.matches(rawPassword, encodedPassword)) {
            throw new DisableLoginException("이메일 또는 비밀번호가 일치하지 않습니다.");
        }
    }
}
