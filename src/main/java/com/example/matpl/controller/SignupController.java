package com.example.matpl.controller;

import com.example.matpl.dto.UserDTO;
import com.example.matpl.usecase.SignupUseCase;
import com.example.matpl.usecase.SignupVerifyUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class SignupController {
    private final SignupUseCase signup;
    private final SignupVerifyUserUseCase signupVerifyUserUseCase;

    @PostMapping("/signup")
    public String registerUser(@ModelAttribute UserDTO userDTO) {
        signup.execute(userDTO);
        return "redirect:/matpl/home";
    }

    @GetMapping("/verify")
    public String verifyUser(@ModelAttribute("token") String token) {
        signupVerifyUserUseCase.execute(token);
        return "verify-success";
    }
}