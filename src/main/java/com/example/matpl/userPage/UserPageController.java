package com.example.matpl.userPage;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class UserPageController {


    @GetMapping("/matpl/users/info")
    public String userInfo(@RequestParam(value = "view", required = false) String view, HttpSession session, Model model) {
        String nickname = (String) session.getAttribute("loginUserNickname");
        String requesterEmail = (String) session.getAttribute("loginUserEmail");

        if (nickname == null) {
            return "redirect:/matpl/home";
        }

        model.addAttribute("sessionName", nickname);

        model.addAttribute("isMypage", "mypage".equals(view));
        model.addAttribute("isFavorites", "favorites".equals(view));
        model.addAttribute("isHistory", "userHistory".equals(view));
        model.addAttribute("isReviews", "userReviews".equals(view));
        model.addAttribute("isChange", "userSetting".equals(view));
        model.addAttribute("isRequest", "requestAdmin".equals(view));

        return "user_info";
    }
}
