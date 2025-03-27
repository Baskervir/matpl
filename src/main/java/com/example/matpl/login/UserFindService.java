package com.example.matpl.login;

import com.example.matpl.entity.UserEntity;
import com.example.matpl.exception.DisableLoginException;
import com.example.matpl.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserFindService {
    private final UserRepository userRepository;

    public UserEntity findUser(LoginDTO loginDTO) {
        Optional<UserEntity> user = userRepository.findByEmail(loginDTO.getEmail());

        return user.orElseThrow(() -> new DisableLoginException("이메일 또는 비밀번호가 일치하지 않습니다."));
    }
}
