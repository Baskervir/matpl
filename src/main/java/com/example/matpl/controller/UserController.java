package com.example.matpl.controller;

import com.example.matpl.entity.UserEntity;
import com.example.matpl.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public ResponseEntity<String> registerUser(@RequestParam String userEmail, @RequestParam String password) {
        userService.registerUser(userEmail, password);
        return ResponseEntity.ok("회원가입 성공!");
    }
}
