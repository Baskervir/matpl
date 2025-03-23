package com.example.matpl.validator;

import com.example.matpl.exception.UserAlreadyExistsException;
import com.example.matpl.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DuplicateValidator {
    private final UserRepository userRepository;

    public void emailValidate(String email) {
        if (userRepository.existsByEmail(email)) {
            throw new UserAlreadyExistsException("이미 사용중인 이메일입니다.");
        }
    }

    public void nicknameValidate(String nickname) {
        if (userRepository.existsByNickname(nickname)) {
            throw new UserAlreadyExistsException("이미 사용중인 닉네임입니다.");
        }
    }
}
