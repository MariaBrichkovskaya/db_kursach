package com.db.kursach.controllers;
import com.db.kursach.models.Supplier;
import com.db.kursach.services.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class SupplierController {
    private final SupplierService supplierService;

    @GetMapping("/suppliers")
    public String suppliers(Model model) {
        model.addAttribute("suppliers", supplierService.listSuppliers());
        return "suppliers";
    }
    @GetMapping("/supplier/{id}")
    public String supplierInfo(@PathVariable Long id, Model model){
        Supplier supplier =supplierService.getSupplierById(id);
        model.addAttribute("supplier",supplier);
        return "supplier-info";
    }
    @PostMapping("/supplier/create")
    public String createSupplier(Supplier supplier) {
        supplierService.saveSupplier(supplier);
        return "redirect:/suppliers";
    }
}
