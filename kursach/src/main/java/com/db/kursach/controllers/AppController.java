package com.db.kursach.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class AppController {
    @GetMapping("/")
    public String main_page(Model model){
        return "main-page";
    }
}
