package com.db.kursach.controllers;


import com.db.kursach.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/orders")
    public String employees(Model model){
        model.addAttribute("orders",orderService.listOrders());
        return "orders";
    }
    /*@PostMapping("/employee/create")
    public String createEmployee(@RequestParam("file") MultipartFile file, Employee employee) throws IOException {
        employeeService.saveEmployee(employee,file);
        return "redirect:/";
    }
    @PostMapping("/employee/{id}/trash")
    public String createImage(@RequestParam("file") MultipartFile file,@PathVariable Long id)throws IOException{
        employeeService.saveImage(file,id);
        return "redirect:/";
    }
    @PostMapping("/employee/delete/{id}")
    public String deleteProduct(@PathVariable Long id){
        employeeService.deleteEmployee(id);
        return "redirect:/";
    }
    @GetMapping("/employee/{id}")
    public String employeeInfo(@PathVariable Long id, Model model){
        Employee employee=employeeService.getEmployeeById(id);
        model.addAttribute("employee",employee);
        model.addAttribute("images",employee.getImages());
        return "employee-info";
    }*/
}
