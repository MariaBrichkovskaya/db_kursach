package com.db.kursach.controllers;

import com.db.kursach.models.Product;
import com.db.kursach.services.ProductService;
import com.db.kursach.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
@PreAuthorize("hasAnyAuthority('ROLE_ADMINISTRATOR', 'ROLE_DIRECTOR', 'ROLE_WAITER', 'ROLE_ACCOUNTANT')")
public class ProductController {
    private final ProductService productService;
    private final UserService userService;

    @GetMapping("/products")
    public String products(Principal principal, Model model){
        model.addAttribute("user", userService.getUserByPrincipal(principal));
        model.addAttribute("products",productService.listProducts());
        return "products";
    }


    @GetMapping("/product/{id}")
    public String productInfo(@PathVariable Long id, Principal principal, Model model){
        Product product=productService.getProductById(id);
        model.addAttribute("user", userService.getUserByPrincipal(principal));
        model.addAttribute("product",product);
        return "product-info";
    }
    @PostMapping("/product/create")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMINISTRATOR', 'ROLE_WAITER', 'ROLE_DIRECTOR')")
    public String createProduct(Product product){
        productService.saveProduct(product);
        return "redirect:/products";
    }
    @PostMapping("/product/delete/{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMINISTRATOR', 'ROLE_WAITER', 'ROLE_DIRECTOR')")
    public String deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
        return "redirect:/products";
    }
    @GetMapping("/product/edit/{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMINISTRATOR', 'ROLE_WAITER', 'ROLE_DIRECTOR')")
    public String editProduct(@PathVariable Long id,Model model)
    {
        Product product=productService.getProductById(id);
        model.addAttribute("product",product);
        return "product-edit";
    }
    @PostMapping("/product/editing/{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMINISTRATOR', 'ROLE_WAITER', 'ROLE_DIRECTOR')")
    public String editingProduct(@PathVariable Long id,Product product)
    {
        productService.editProduct(id,product);
        return "redirect:/product/{id}";
    }

}
