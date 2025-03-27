package com.example.matpl.login;

import com.example.matpl.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PasswordMatchingService {
    private final BCryptPasswordEncoder passwordEncoder;

    public boolean passwordCheck(UserEntity user, LoginDTO loginDTO) {
        return passwordEncoder.matches(loginDTO.getPassword(), user.getPassword());
    }
}
