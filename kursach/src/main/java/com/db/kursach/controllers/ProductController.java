package com.db.kursach.controllers;

import com.db.kursach.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    @GetMapping("/products")
    public String employees(Model model){
        model.addAttribute("products",productService.listProducts());
        return "products";
    }
}
