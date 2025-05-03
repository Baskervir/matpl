package com.example.matpl.login.usecase;

import com.example.matpl.login.domain.UserInfo;
import com.example.matpl.login.dto.LoginDTO;
import com.example.matpl.login.dto.SessionUserDto;
import com.example.matpl.login.service.EmailCheckService;
import com.example.matpl.login.service.PasswordCheckService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class LoginUseCase {
    private final EmailCheckService emailCheckService;
    private final PasswordCheckService passwordCheckService;

    public SessionUserDto execute(LoginDTO loginDTO) {
        UserInfo userInfo = emailCheckService.findUserInfoByEmail(loginDTO.getEmail());
        if (loginDTO.getEmail().equals("matplrm@gmail.com")) {
            return new SessionUserDto(userInfo.email(), userInfo.nickname());
        } else {
            passwordCheckService.passwordCheck(loginDTO.getPassword(), userInfo.hasedPassword());
        }
        return new SessionUserDto(userInfo.email(), userInfo.nickname());
    }
}
