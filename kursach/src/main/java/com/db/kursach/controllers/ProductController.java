package com.db.kursach.controllers;

import com.db.kursach.models.Employee;
import com.db.kursach.models.Product;
import com.db.kursach.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    @GetMapping("/products")
    public String products(Model model){
        model.addAttribute("products",productService.listProducts());
        return "products";
    }
    @GetMapping("/product/{id}")
    public String productInfo(@PathVariable Long id, Model model){
        Product product=productService.getProductById(id);
        model.addAttribute("product",product);
        return "product-info";
    }

}
