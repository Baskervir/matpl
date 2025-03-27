package com.example.matpl.login;

import com.example.matpl.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/login")
@RequiredArgsConstructor
public class LoginController {
    private final LoginUseCase loginUseCase;

    @PostMapping("")
    public ResponseEntity<ApiResponse<Void>> userLogin(@RequestBody LoginDTO loginDTO) {
        loginUseCase.execute(loginDTO);
        return ResponseEntity.ok(
                new ApiResponse<>(true, "로그인 성공", null)
        );
    }
}
