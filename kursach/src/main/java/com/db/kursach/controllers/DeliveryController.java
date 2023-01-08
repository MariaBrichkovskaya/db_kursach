package com.db.kursach.controllers;
import com.db.kursach.models.Delivery;
import com.db.kursach.services.DeliveryService;
import com.db.kursach.services.EmployeeService;
import com.db.kursach.services.ProductService;
import com.db.kursach.services.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class DeliveryController {
    private final DeliveryService deliveryService;
    private final SupplierService supplierService;
    private final ProductService productService;
    private final EmployeeService employeeService;
    @GetMapping("/deliveries")
    public String deliveries(Model model){
        model.addAttribute("deliveries",deliveryService.listDeliveries());
        model.addAttribute("suppliers",supplierService.listSuppliers());
        model.addAttribute("products",productService.listProducts());
        model.addAttribute("employees",employeeService.listEmployees(null));
        return "deliveries";
    }

    @GetMapping("/delivery/{id}")
    public String productInfo(@PathVariable Long id, Model model){
        Delivery delivery = deliveryService.getDeliveryById(id);
        model.addAttribute("delivery", delivery);
        return "delivery-info";
    }
    @PostMapping("/delivery/create")
    public String createDelivery(Delivery delivery){
        deliveryService.saveDelivery(delivery);
        return "redirect:/";
    }
}
