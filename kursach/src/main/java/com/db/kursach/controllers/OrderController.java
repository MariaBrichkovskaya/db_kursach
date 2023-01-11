package com.db.kursach.controllers;



import com.db.kursach.models.Order;
import com.db.kursach.models.OrderComposition;
import com.db.kursach.services.EmployeeService;
import com.db.kursach.services.OrderService;
import com.db.kursach.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.*;

@Controller
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final ProductService productService;
    private final EmployeeService employeeService;
    Order order;
    @GetMapping("/orders")
    public String orders(Model model){
        List<Order> listOrders = orderService.listOrders();
        listOrders.sort(Comparator.comparing(Order::getTime).reversed());
        model.addAttribute("orders",listOrders);
        return "orders";
    }
    @GetMapping("/order/{id}")
    public String productInfo(@PathVariable Long id, Model model){
        Order order = orderService.getOrderById(id);
        model.addAttribute("order",order);
        return "order-info";
    }
    @PostMapping("/order/employee{id}/create")
    public String startOrderCreation(@PathVariable Long id, Model model){
        order = new Order();
        order.setWaiter(employeeService.getEmployeeById(id));
        order.setTime(new Date());
        order.setPrice(0.0);
        order.setDescription("");
        order.setOrderComposition(new ArrayList<>());
        model.addAttribute("order", order);
        model.addAttribute("products", productService.listProducts());
        model.addAttribute("employee", order.getWaiter());
        return "order-creation";
    }
    @GetMapping("/order/create")
    public String orderCreation(Model model){
        model.addAttribute("order", order);
        model.addAttribute("products", productService.listProducts());
        return "order-creation";
    }
    @PostMapping("/order/addProduct")
    public String addProductInOrder(Long id, int productAmount){
        order = orderService.addProductInOrder(order, productService.getProductById(id), productAmount);
        return "redirect:/order/create";
    }
    @PostMapping("/order/save")
    public String saveOrder(){
        orderService.saveOrder(order);
        return "redirect:/orders";
    }
    @PostMapping("/order/delete/{id}")
    public String deleteOrder(@PathVariable Long id){
        orderService.deleteOrder(id);
        return "redirect:/orders";
    }

}
