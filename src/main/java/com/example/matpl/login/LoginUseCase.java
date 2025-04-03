package com.example.matpl.login;

import com.example.matpl.entity.UserEntity;
import com.example.matpl.exception.DisableLoginException;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class LoginUseCase {
    private final UserFindService userFindService;
    private final PasswordMatchingService passwordMatchingService;
    private final HttpSession session;

    public void execute(LoginDTO loginDTO) {
        UserEntity user = userFindService.findUser(loginDTO);
        boolean isPasswordCorrect = passwordMatchingService.passwordCheck(user, loginDTO);

        if (!isPasswordCorrect) {
            throw new DisableLoginException("이메일 또는 비밀번호가 일치하지 않습니다.");
        }

        session.setAttribute("loginUser", user.getNickname());

        log.info("로그인 성공" + user.getNickname());
    }
}
