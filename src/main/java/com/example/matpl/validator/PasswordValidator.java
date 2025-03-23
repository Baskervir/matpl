package com.example.matpl.validator;

import com.example.matpl.exception.InvalidPasswordException;
import com.example.matpl.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PasswordValidator {
    private final UserRepository userRepository;

    public void validate(String password) throws InvalidPasswordException {
        if (password.length() < 8) {
            throw new InvalidPasswordException("비밀번호는 8자 이상이어야 합니다.");
        }
        if (!password.matches(".*[A-Z].*")) {
            throw new InvalidPasswordException("대문자가 포함되어야 합니다.");
        }
        if (!password.matches(".*[!@#$%^&*()].*")) {
            throw new InvalidPasswordException("특수문자가 포함되어야 합니다.");
        }
    }
}
