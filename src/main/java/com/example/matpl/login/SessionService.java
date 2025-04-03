package com.example.matpl.login;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SessionService {
    private final HttpSession session;

    public void login(LoginDTO loginDTO) {
        session.setAttribute("loginUser", loginDTO.getEmail());
    }
}
