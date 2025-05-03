package com.example.matpl.login.controller;

import com.example.matpl.login.dto.LoginDTO;
import com.example.matpl.login.dto.SessionUserDto;
import com.example.matpl.login.usecase.LoginUseCase;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/log")
@RequiredArgsConstructor
public class LoginController {
    private final LoginUseCase loginUseCase;

    @PostMapping("/in")
    public String userLogin(@ModelAttribute LoginDTO loginDTO, HttpSession session, Model model, RedirectAttributes redirectAttributes) {
        try {
            SessionUserDto sessionUser = loginUseCase.execute(loginDTO);
            session.setAttribute("loginUserEmail", sessionUser.getEmail());
            session.setAttribute("loginUserNickname", sessionUser.getNickname());
            model.addAttribute("sessionName", sessionUser.getNickname());
            return "redirect:/matpl/home";
        } catch (Exception e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
            return "redirect:/matpl/home";
        }

    }

    @PostMapping("/out")
    public String userLogout(HttpSession session) {
        session.invalidate();
        return "redirect:/matpl/home";
    }
}
