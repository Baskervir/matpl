package com.example.matpl.controller;

import com.example.matpl.dto.UserDTO;
import com.example.matpl.response.ApiResponse;
import com.example.matpl.usecase.SignupUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final SignupUseCase signup;

    @PostMapping("/signup")
    public ResponseEntity<ApiResponse<Void>> registerUser(@RequestBody UserDTO userDTO) {
        signup.execute(userDTO);
        return ResponseEntity.ok(
                new ApiResponse<>(true, "회원가입 성공", null)
        );
    }

//    @DeleteMapping("/signout")
//    public ResponseEntity<ApiResponse<Void>>
}