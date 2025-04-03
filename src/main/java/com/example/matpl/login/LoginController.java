package com.example.matpl.login;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {
    private final LoginUseCase loginUseCase;

    @PostMapping("/in")
    public String userLogin(@ModelAttribute LoginDTO loginDTO) {
        loginUseCase.execute(loginDTO);
        return "";
    }

    @PostMapping("/out")
    public String userLogout() {
        return "redirect:/matpl/home";
    }
}
