package com.db.kursach.controllers;

import com.db.kursach.models.User;
import com.db.kursach.repositories.viewsRepository.WellPaidEmployeesRepository;
import com.db.kursach.services.EmployeeService;
import com.db.kursach.services.ProductService;
import com.db.kursach.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class AppController {
    private final ProductService productService;
    private final EmployeeService employeeService;
    private final UserService userService;
    private final WellPaidEmployeesRepository wellPaidEmployeesRepository;
    User user;

    @GetMapping("/")
    public String main_page(Principal principal, Model model){
        model.addAttribute("user", userService.getUserByPrincipal(principal));
        return "main-page";
    }

    @GetMapping("/views")
    public String views(Model model){
        model.addAttribute("employees", employeeService.listEmployees(null));
        model.addAttribute("products",productService.listProducts());
        model.addAttribute("wellPaidEmployees", wellPaidEmployeesRepository.findAll());
        return "views";
    }
}
