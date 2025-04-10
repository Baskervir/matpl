package com.example.matpl.login;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class LoginUseCase {
    private final LoginService loginService;
    private final HttpSession session;

    public void execute(LoginDTO loginDTO) {
        SessionUserDto sessionUserDto = loginService.authenticate(loginDTO);
        session.setAttribute("loginUser", sessionUserDto.getNickname());
        log.info("로그인 성공: {}", sessionUserDto.getNickname());
    }
}
