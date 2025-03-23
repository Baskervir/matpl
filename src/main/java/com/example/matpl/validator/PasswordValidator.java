package com.example.matpl.validator;

import com.example.matpl.exception.InvalidPasswordException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PasswordValidator {
    public void validate(String password, String passwordCheck) throws InvalidPasswordException {
        if (password.length() < 8) {
            throw new InvalidPasswordException("비밀번호는 8자 이상이어야 합니다.");
        }
        if (!password.matches(".*[A-Z].*")) {
            throw new InvalidPasswordException("대문자가 포함되어야 합니다.");
        }
        if (!password.matches(".*[!@#$%^&*()].*")) {
            throw new InvalidPasswordException("특수문자가 포함되어야 합니다.");
        }
        if (!password.equals(passwordCheck)) {
            throw new InvalidPasswordException("비밀번호 확인이 비밀번호와 일치하지 않습니다. 다시 입력해주세요.");
        }
    }
}
