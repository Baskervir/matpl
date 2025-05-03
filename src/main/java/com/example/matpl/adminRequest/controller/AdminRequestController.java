package com.example.matpl.adminRequest.controller;

import com.example.matpl.adminRequest.usecase.AdminRequestUsecase;
import com.example.matpl.adminRequest.dto.AdminRequesterDto;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
public class AdminRequestController {
    private final AdminRequestUsecase usecase;

    @PostMapping("/matpl/users/mypage/requestAdmin")
    public String requestAdmin(@ModelAttribute AdminRequesterDto dto, HttpSession session, RedirectAttributes redirect) {
        String email = (String) session.getAttribute("loginUserEmail");

        usecase.requestAndSaveRequesterInfo(dto);

        redirect.addFlashAttribute("message", "요청이 접수되었습니다.");
        return "redirect:/matpl/users/info?view=requestAdmin";
    }
}
