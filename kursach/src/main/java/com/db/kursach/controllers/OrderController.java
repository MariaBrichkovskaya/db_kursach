package com.db.kursach.controllers;



import com.db.kursach.models.Order;
import com.db.kursach.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/orders")
    public String orders(Model model){
        model.addAttribute("orders",orderService.listOrders());
        return "orders";
    }
    @GetMapping("/order/{id}")
    public String productInfo(@PathVariable Long id, Model model){
        Order order =orderService.getOrderById(id);
        model.addAttribute("order",order);
        return "order-info";
    }
    @PostMapping("/order/create")
    public String createOrder(Order order){
        orderService.saveOrder(order);
        return "redirect:/";
    }
}
