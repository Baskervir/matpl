package com.example.matpl.login.service;

import com.example.matpl.login.dto.LoginDTO;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SessionService {
    private final HttpSession session;

    public void login(LoginDTO loginDTO) {
        session.setAttribute("loginUserNickname", loginDTO.getEmail());
    }
}
