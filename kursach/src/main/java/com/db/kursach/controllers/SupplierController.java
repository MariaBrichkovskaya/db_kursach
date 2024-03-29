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
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
@PreAuthorize("hasAnyAuthority('ROLE_ADMINISTRATOR', 'ROLE_DIRECTOR', 'ROLE_WAITER', 'ROLE_ACCOUNTANT')")
public class SupplierController {
    private final SupplierService supplierService;
    private final UserService userService;
    private final AppController appController;
    @GetMapping("/suppliers")
    public String suppliers(@RequestParam(name = "name",required = false) String name, Model model) {
        String searchString = "";
        if (name != null) searchString =name;
        model.addAttribute("user", appController.user);
        model.addAttribute("searchString", searchString);
        model.addAttribute("suppliers", supplierService.listSuppliers(name));
        return "suppliers";
    }
    @GetMapping("/supplier/{id}")
    public String supplierInfo(@PathVariable Long id, Model model){
        Supplier supplier =supplierService.getSupplierById(id);
        model.addAttribute("user", appController.user);
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
