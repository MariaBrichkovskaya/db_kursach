package com.db.kursach.controllers;

import com.db.kursach.models.User;
import com.db.kursach.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }
    @PostMapping("/registration")
    public String createUser(User user, Model model){
        if(!userService.createUser(user))
        {
            model.addAttribute("errorMessage","Ошибка регистрации пользователя с логином: "+user.getLogin());
            return "registration";
        }
        return "redirect:/login";
    }
}
