package com.example.matpl.controller;

import com.example.matpl.dto.UserDTO;
import com.example.matpl.response.ApiResponse;
import com.example.matpl.usecase.SignupUseCase;
import com.example.matpl.usecase.SignupVerifyUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class SignupController {
    private final SignupUseCase signup;
    private final SignupVerifyUserUseCase signupVerifyUserUseCase;

    @PostMapping("/signup")
    public ResponseEntity<ApiResponse<Void>> registerUser(@RequestBody UserDTO userDTO) {
        signup.execute(userDTO);
        return ResponseEntity.ok(
                new ApiResponse<>(true, "회원가입 성공", null)
        );
    }

    @GetMapping("/verify")
    public ResponseEntity<ApiResponse<Void>> verifyUser(@RequestParam("token") String token) {
        signupVerifyUserUseCase.execute(token);
        return ResponseEntity.ok(
                new ApiResponse<>(true, "이메일 인증이 완료되었습니다.", null)
        );
    }
}