package com.example.matpl.login.service;

import com.example.matpl.entity.UserEntity;
import com.example.matpl.exception.DisableLoginException;
import com.example.matpl.login.dto.SessionUserDto;
import com.example.matpl.login.dto.LoginDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final UserFindService userFindService;
    private final PasswordMatchingService passwordMatchingService;

    public SessionUserDto authenticate(LoginDTO loginDTO) {
        UserEntity user = userFindService.findUser(loginDTO);


        if (!passwordMatchingService.passwordCheck(user, loginDTO)) {
            throw new DisableLoginException("이메일 또는 비밀번호가 일치하지 않습니다.");
        }

        return new SessionUserDto(user.getNickname(), user.getEmail());
    }
}
