package com.db.kursach.controllers;



import com.db.kursach.models.Order;
import com.db.kursach.services.EmployeeService;
import com.db.kursach.services.OrderService;
import com.db.kursach.services.ProductService;
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
    private final ProductService productService;
    private final EmployeeService employeeService;

    Order order;

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


    @PostMapping("/order/addNew")
    public String createOrder(Model model){
        order = new Order();
        model.addAttribute("order", new Order());
        model.addAttribute("products", productService.listProducts());
        model.addAttribute("employees", employeeService.listEmployees(null));
        return "order-creation";
    }

    @PostMapping("/order/create")
    public String editOrder(Model model){
        model.addAttribute("order", new Order());
        model.addAttribute("products", productService.listProducts());
        model.addAttribute("employees", employeeService.listEmployees(null));
        return "order-creation";
    }

    @PostMapping("/order/create/addProduct")
    public String addProductInOrder(Order order){
        //order.
        return "redirect:/order/create";
    }
}
