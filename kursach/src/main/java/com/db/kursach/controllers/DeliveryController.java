package com.db.kursach.controllers;

import com.db.kursach.models.Delivery;
import com.db.kursach.services.DeliveryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class DeliveryController {
    private final DeliveryService deliveryService;
    @GetMapping("/deliveries")
    public String deliveries(Model model){
        model.addAttribute("deliveries",deliveryService.listDeliveries());
        return "deliveries";
    }
    @GetMapping("/delivery/{id}")
    public String productInfo(@PathVariable Long id, Model model){
        Delivery delivery = deliveryService.getDeliveryById(id);
        model.addAttribute("delivery", delivery);
        return "delivery-info";
    }
}
