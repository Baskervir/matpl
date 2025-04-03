package com.example.matpl.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class IndexController {
    @GetMapping("/matpl/home")
    public String index() {
        System.out.println("print Index");
        return "index";
    }
}
