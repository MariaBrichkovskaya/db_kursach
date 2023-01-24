package com.db.kursach.controllers;

import com.db.kursach.repositories.viewsRepository.WellPaidEmployeesRepository;
import com.db.kursach.services.EmployeeService;
import com.db.kursach.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class AppController {
    private final ProductService productService;
    private final EmployeeService employeeService;
    private final WellPaidEmployeesRepository wellPaidEmployeesRepository;

    @GetMapping("/")
    public String main_page(Model model){
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
