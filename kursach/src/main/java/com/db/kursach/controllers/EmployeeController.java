package com.db.kursach.controllers;

import com.db.kursach.models.Employee;
import com.db.kursach.models.User;
import com.db.kursach.repositories.EmployeeRepository;
import com.db.kursach.repositories.UserRepository;
import com.db.kursach.services.EmployeeService;
import com.db.kursach.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.Principal;

@Controller
@RequiredArgsConstructor
@PreAuthorize("hasAnyAuthority('ROLE_ADMINISTRATOR', 'ROLE_DIRECTOR', 'ROLE_WAITER', 'ROLE_ACCOUNTANT')")
public class EmployeeController {
    private final EmployeeService employeeService;
    private final EmployeeService employeeService1;
    private final UserService userService;
    private final EmployeeRepository employeeRepository;
    @GetMapping("/employees")
    public String employees(@RequestParam(name = "fullName",required = false) String fullName, Principal principal, Model model){
        model.addAttribute("employees",employeeService.listEmployees(fullName));
        String searchString = "";
        if (fullName != null) searchString =fullName;
        model.addAttribute("user",userService.getUserByPrincipal(principal));
        model.addAttribute("searchString", searchString);
        return "employees";
    }
    @PreAuthorize("hasAnyAuthority('ROLE_ADMINISTRATOR', 'ROLE_DIRECTOR')")
    @PostMapping("/employee/create")
    public String createEmployee(Employee employee) throws IOException{
        employeeService.saveEmployee(employee);
        return "redirect:/employees";
    }
    @PostMapping("/employee/{id}/trash")
    public String createImage(@RequestParam("file") MultipartFile file,@PathVariable Long id)throws IOException{
        employeeService.saveImage(file,id);
        return "redirect:/employee/{id}";
    }

    @PostMapping("/employee/delete/{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMINISTRATOR', 'ROLE_DIRECTOR')")
    public String deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmployee(id);
        return "redirect:/employees";
    }

    @GetMapping("/employee/{id}")
    public String employeeInfo(@PathVariable Long id,Model model, Principal principal){
        Employee employee=employeeService.getEmployeeById(id);
        model.addAttribute("user", userService.getUserByPrincipal(principal));
        model.addAttribute("employee",employee);
        return "employee-info";
    }

    @GetMapping("/employee/{id}/image")
    public ResponseEntity<?> getEmployeeImage(@PathVariable Long id){
        Employee employee=employeeService.getEmployeeById(id);
        return ResponseEntity.ok()
                .body(new InputStreamResource(new ByteArrayInputStream(employee.getImage_bytes())));
    }

    @GetMapping("/employee/edit/{id}")
    public String editEmployee(@PathVariable Long id,Principal principal, Model model)
    {   if(userService.getUserByPrincipal(principal).getEmployee().getId()!=id &&
            userService.getUserByPrincipal(principal).isWaiter()) return "redirect:/employee/{id}";
        Employee employee=employeeService.getEmployeeById(id);
        model.addAttribute("user",userService.getUserByPrincipal(principal));
        model.addAttribute("employee",employee);
        return "employee-edit";
    }
    @PostMapping("/employee/editing/{id}")
    public String editingEmployee(@PathVariable Long id,Principal principal,Employee employee)
    {
        User user = userService.getUserByPrincipal(principal);
        if(user.getEmployee().getId()!=employee.getId() &&
                user.isWaiter()) return  "redirect:/employee/{id}";
        employeeService.editEmployee(id,employee);
        return "redirect:/employee/{id}";
    }

}