package com.example.matpl.controller;

import com.example.matpl.dto.UserDTO;
import com.example.matpl.entity.UserEntity;
import com.example.matpl.enums.UserStatus;
import com.example.matpl.repository.UserRepository;
import com.example.matpl.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserRepository userRepository;

    @PostMapping("/signup")
    public ResponseEntity<String> registerUser(@Valid @RequestBody UserDTO userDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getFieldError().getDefaultMessage());
        }
        userService.registerUser(userDTO);
        return ResponseEntity.ok("회원가입 성공!");
    }

//    @GetMapping("/verify")
//    public ResponseEntity<String> verifyEmail(@RequestParam("token") String token) {
//        Optional<UserEntity> optionalUser = userRepository.findByVerificationToken(token);
//
//        if (optionalUser.isEmpty()) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("유효하지 않은 토큰입니다.");
//        }
//
//        UserEntity user = optionalUser.get();
//
//        if (user.getStatus() == UserStatus.VERIFIED) {
//            return ResponseEntity.ok("이미 인증된 계정입니다.");
//        }
//
//        user.setStatus(UserStatus.VERIFIED);
//        user.setVerificationToken(null);
//        userRepository.save(user);
//
//        return ResponseEntity.ok("이메일 인증이 완료되었습니다! 이제 로그인하세요.");
//    }
}