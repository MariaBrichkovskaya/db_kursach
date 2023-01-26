package com.db.kursach.controllers;



import com.db.kursach.models.Order;
import com.db.kursach.models.OrderComposition;
import com.db.kursach.models.OrderCompositionKey;
import com.db.kursach.services.EmployeeService;
import com.db.kursach.services.OrderService;
import com.db.kursach.services.ProductService;
import com.db.kursach.services.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.*;

@Controller
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final ProductService productService;
    private final UserService userService;
    Order order;
    @GetMapping("/orders")
    public String orders(Principal principal, Model model){
        List<Order> listOrders = orderService.listOrders();
        listOrders.sort(Comparator.comparing(Order::getTime).reversed());
        model.addAttribute("user", userService.getUserByPrincipal(principal));
        model.addAttribute("orders",listOrders);
        return "orders";
    }
    @GetMapping("/order/{id}")
    public String orderInfo(@PathVariable Long id, Principal principal, Model model){
        Order order = orderService.getOrderById(id);
        model.addAttribute("user", userService.getUserByPrincipal(principal));
        model.addAttribute("order",order);
        return "order-info";
    }
    @PostMapping("/order/create/start")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMINISTRATOR', 'ROLE_WAITER', 'ROLE_DIRECTOR')")
    public String startOrderCreation(Principal principal, Model model){
        order = new Order();
        order.setWaiter(userService.getUserByPrincipal(principal).getEmployee());
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
    @PreAuthorize("hasAnyAuthority('ROLE_ADMINISTRATOR', 'ROLE_WAITER', 'ROLE_DIRECTOR')")
    public String orderCreation(Model model){
        model.addAttribute("order", order);
        model.addAttribute("products", productService.listProducts());
        return "order-creation";
    }
    @PostMapping("/order/addProduct")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMINISTRATOR', 'ROLE_WAITER', 'ROLE_DIRECTOR')")
    public String addProductInOrder(Long productId, int productAmount){
        order = orderService.addProductInOrder(order, productService.getProductById(productId), productAmount);
        return "redirect:/order/create";
    }

    @PostMapping("/order/save")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMINISTRATOR', 'ROLE_WAITER', 'ROLE_DIRECTOR')")
    public String saveOrder(String description){
        order.setDescription(description);
        orderService.saveOrder(order);
        return "redirect:/orders";
    }
    @PostMapping("/order/delete/{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMINISTRATOR', 'ROLE_WAITER', 'ROLE_DIRECTOR')")
    public String deleteOrder(@PathVariable Long id){
        orderService.deleteOrder(id);
        return "redirect:/orders";
    }

    @GetMapping("/order/deletePosition/{index}")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMINISTRATOR', 'ROLE_WAITER', 'ROLE_DIRECTOR')")
    public String deleteProductFromOrder(@PathVariable Integer index) {
        order = orderService.deleteOrderPosition(index, order);
        return "redirect:/order/create";
    }


}
