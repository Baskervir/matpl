package com.example.matpl.adminRequest;

import com.example.matpl.adminRequest.dto.AdminRequestDto;
import com.example.matpl.adminRequest.service.AdminRequestService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class AdminRequestController {
    private final AdminRequestService adminRequestService;

    @PostMapping("/matpl/users/mypage/requestAdmin")
    public String submitRequest(@ModelAttribute AdminRequestDto dto, HttpSession session) {
        String requesterEmail = (String) session.getAttribute("loginUser");
        adminRequestService.saveRequest(dto, requesterEmail);
        return "redirect:/matpl/home";
    }
}
