package com.db.kursach.controllers;

import com.db.kursach.models.Employee;
import com.db.kursach.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;
    @GetMapping("/")
    public String employees(@RequestParam(name = "fullName",required = false) String fullName, Model model){
        model.addAttribute("employees",employeeService.listEmployees(fullName));
        String searchString = "";
        if (fullName != null) searchString =fullName;
        model.addAttribute("searchString", searchString);
        return "employees";
    }
    @PostMapping("/employee/create")
    public String createEmployee(Employee employee){
        employeeService.saveEmployee(employee);
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
    public String employeeInfo(@PathVariable Long id,Model model){
        Employee employee=employeeService.getEmployeeById(id);
        model.addAttribute("employee",employee);
        model.addAttribute("images",employee.getImages());
        return "employee-info";
    }
}
