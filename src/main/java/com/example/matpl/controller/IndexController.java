package com.example.matpl.controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class IndexController {
    @GetMapping("/matpl/home")
    public String index(HttpSession session, Model model) {
        String nickname = (String) session.getAttribute("loginUserNickname");
        if (nickname != null) {
            model.addAttribute("sessionName", nickname);
        }
        return "index";
    }
}
