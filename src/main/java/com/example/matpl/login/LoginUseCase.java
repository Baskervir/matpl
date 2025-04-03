package com.example.matpl.login;

import com.example.matpl.entity.UserEntity;
import com.example.matpl.exception.DisableLoginException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LoginUseCase {
    private final UserFindService userFindService;
    private final PasswordMatchingService passwordMatchingService;

    public void execute(LoginDTO loginDTO) {
        UserEntity user = userFindService.findUser(loginDTO);
        boolean isPasswordCorrect = passwordMatchingService.passwordCheck(user, loginDTO);

        if (!isPasswordCorrect) {
            throw new DisableLoginException("이메일 또는 비밀번호가 일치하지 않습니다.");
        }

        System.out.println("로그인 성공" + user);
    }
}
