package com.example.matpl.login.usecase;

import com.example.matpl.login.dto.SessionUserDto;
import com.example.matpl.login.dto.LoginDTO;
import com.example.matpl.login.service.LoginService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

@Slf4j
@Component
@RequiredArgsConstructor
public class LoginUseCase {
    private final LoginService loginService;

    public void execute(LoginDTO loginDTO, HttpSession session, Model model) {
        SessionUserDto sessionUserDto = loginService.authenticate(loginDTO);
        session.setAttribute("loginUserNickname", sessionUserDto.getNickname());
        session.setAttribute("loginUserEmail", sessionUserDto.getEmail());
        String nickname = (String) session.getAttribute("loginUserNickname");
        model.addAttribute("sessionName", nickname);
        log.info("로그인 성공: {}", sessionUserDto.getNickname());
    }
}
