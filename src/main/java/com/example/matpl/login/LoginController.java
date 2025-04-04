package com.example.matpl.login;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/log")
@RequiredArgsConstructor
public class LoginController {
    private final LoginUseCase loginUseCase;

    @PostMapping("/in")
    public String userLogin(@ModelAttribute LoginDTO loginDTO, HttpSession session, Model model) {
        loginUseCase.execute(loginDTO);
        String nickname = (String) session.getAttribute("loginUser");
        model.addAttribute("sessionName", nickname);
        return "index";
    }

    @PostMapping("/out")
    public String userLogout(HttpSession session) {
        session.invalidate();
        return "redirect:/matpl/home";
    }
}
