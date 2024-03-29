package com.db.kursach.controllers;
import com.db.kursach.models.Delivery;
import com.db.kursach.models.User;
import com.db.kursach.services.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

@Controller
@RequiredArgsConstructor
@PreAuthorize("hasAnyAuthority('ROLE_ADMINISTRATOR', 'ROLE_DIRECTOR', 'ROLE_WAITER', 'ROLE_ACCOUNTANT')")
public class DeliveryController {
    private final DeliveryService deliveryService;
    private final SupplierService supplierService;
    private final ProductService productService;
    private final EmployeeService employeeService;
    private final UserService userService;
    private final AppController appController;
    @GetMapping("/deliveries")
    public String deliveries(@RequestParam(name = "date",required = false) LocalDate date, Model model){
        List<Delivery> listDeliveries = deliveryService.listDeliveries(date);
        listDeliveries.sort(Comparator.comparing(Delivery::getDate).reversed());
        model.addAttribute("deliveries",listDeliveries);
        LocalDate searchField = LocalDate.now();
        if (date != null) searchField =date;
        model.addAttribute("searchField", searchField);
        model.addAttribute("user",appController.user);
        model.addAttribute("suppliers",supplierService.listSuppliers(null));
        model.addAttribute("products",productService.listProducts(null));
        model.addAttribute("employees",employeeService.listEmployees(null));
        return "deliveries";
    }

    @GetMapping("/delivery/{id}")
    public String deliveryInfo(@PathVariable Long id, Model model){
        Delivery delivery = deliveryService.getDeliveryById(id);
        model.addAttribute("user",appController.user);
        model.addAttribute("delivery", delivery);
        return "delivery-info";
    }
    @PreAuthorize("hasAnyAuthority('ROLE_ADMINISTRATOR', 'ROLE_DIRECTOR', 'ROLE_WAITER')")
    @PostMapping("/delivery/create")
    public String createDelivery(Delivery delivery){
        deliveryService.saveDelivery(delivery);
        return "redirect:/deliveries";
    }
    @PreAuthorize("hasAnyAuthority('ROLE_ADMINISTRATOR', 'ROLE_DIRECTOR', 'ROLE_WAITER')")
    @PostMapping("/delivery/delete/{id}")
    public String deleteDelivery(@PathVariable Long id){
        deliveryService.deleteDelivery(id);
        return "redirect:/deliveries";
    }
    @PreAuthorize("hasAnyAuthority('ROLE_ADMINISTRATOR', 'ROLE_DIRECTOR', 'ROLE_WAITER')")
    @GetMapping("/delivery/edit/{id}")
    public String editDelivery(@PathVariable Long id, Model model)
    {
        Delivery delivery=deliveryService.getDeliveryById(id);
        model.addAttribute("user",appController.user);
        model.addAttribute("delivery",delivery);
        model.addAttribute("suppliers",supplierService.listSuppliers(null));
        model.addAttribute("products",productService.listProducts(null));
        model.addAttribute("employees",employeeService.listEmployees(null));
        return "delivery-edit";
    }
    @PreAuthorize("hasAnyAuthority('ROLE_ADMINISTRATOR', 'ROLE_DIRECTOR', 'ROLE_WAITER')")
    @PostMapping("/delivery/editing/{id}")
    public String editingDelivery(@PathVariable Long id,Delivery delivery)
    {
        deliveryService.editDelivery(id,delivery);
        return "redirect:/delivery/{id}";
    }


}
