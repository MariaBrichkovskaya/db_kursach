package com.db.kursach.controllers;
import com.db.kursach.models.Supplier;
import com.db.kursach.repositories.viewsRepository.WellPaidEmployeesRepository;
import com.db.kursach.services.SupplierService;
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
public class SupplierController {
    private final SupplierService supplierService;
    private final UserService userService;
    @GetMapping("/suppliers")
    public String suppliers(Principal principal, Model model) {
        model.addAttribute("user", userService.getUserByPrincipal(principal));
        model.addAttribute("suppliers", supplierService.listSuppliers());
        return "suppliers";
    }
    @GetMapping("/supplier/{id}")
    public String supplierInfo(@PathVariable Long id, Principal principal, Model model){
        Supplier supplier =supplierService.getSupplierById(id);
        model.addAttribute("user", userService.getUserByPrincipal(principal));
        model.addAttribute("supplier",supplier);
        return "supplier-info";
    }
    @PostMapping("/supplier/create")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMINISTRATOR', 'ROLE_DIRECTOR')")
    public String createSupplier(Supplier supplier) {
        supplierService.saveSupplier(supplier);
        return "redirect:/suppliers";
    }
    @PostMapping("/supplier/delete/{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMINISTRATOR', 'ROLE_DIRECTOR')")
    public String deleteSupplier(@PathVariable Long id){
        supplierService.deleteSupplier(id);
        return "redirect:/suppliers";
    }
    @GetMapping("/supplier/edit/{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMINISTRATOR', 'ROLE_DIRECTOR')")
    public String editSupplier(@PathVariable Long id,Model model)
    {
        Supplier supplier=supplierService.getSupplierById(id);
        model.addAttribute("supplier",supplier);
        return "supplier-edit";
    }
    @PostMapping("/supplier/editing/{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMINISTRATOR', 'ROLE_DIRECTOR')")
    public String editingSupplier(@PathVariable Long id,Supplier supplier)
    {
        supplierService.editSupplier(id,supplier);
        return "redirect:/supplier/{id}";
    }

}
