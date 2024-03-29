package com.db.kursach.services;

import com.db.kursach.enums.Role;
import com.db.kursach.models.Employee;
import com.db.kursach.models.User;
import com.db.kursach.repositories.EmployeeRepository;
import com.db.kursach.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class EmployeeService {
    public final EmployeeRepository employeeRepository;
    private final UserService userService;
    private final UserRepository userRepository;

    public List<Employee> listEmployees(String fullName){
        if(fullName!=null) return employeeRepository.findByFullNameContaining(fullName);
        return employeeRepository.findAll();
    }
    public void saveEmployee(Employee employee) {
        log.info("Saving new Employee.{}",employee);
        employeeRepository.save(employee);
    }
    public void saveImage(MultipartFile file,Long id) throws IOException {
        Employee employee=employeeRepository.findById(id).orElseThrow();
        if(!file.isEmpty()) {
            employee.setImage_bytes(file.getBytes());
            employeeRepository.save(employee);
        }
    }

    public void deleteEmployee(Long id){
        employeeRepository.deleteById(id);
    }
    public void deleteImage(Long id){
        Employee employee= getEmployeeById(id);
        employee.setImage_bytes(null);
        employeeRepository.save(employee);
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElseThrow();
    }
    public Employee getEmployeeByEmail(String email) {
        return employeeRepository.findByEmail(email);
    }
    public void editEmployee(Long id, Employee employee){
        try {
            Employee employee1=employeeRepository.findById(id).orElseThrow();
            User user = userRepository.findByEmployeeId(id);
            employee1.setDate(employee.getDate());
            employee1.setImage_bytes(employee1.getImage_bytes());
            employee1.setExperience(employee.getExperience());
            employee1.setFullName(employee.getFullName());
            employee1.setPhone(employee.getPhone());
            employee1.setPosition1(employee.getPosition1());
            employee1.setSalary(employee.getSalary());
            employee1.setEmail(employee.getEmail());
            user.setEmail(employee.getEmail());
            user=userService.setUserRole(employee, user);
            employeeRepository.save(employeeRepository.findById(id).orElseThrow());
            userRepository.save(user);
        }catch (NullPointerException e){
            Employee employee1=employeeRepository.findById(id).orElseThrow();
            employee1.setDate(employee.getDate());
            employee1.setImage_bytes(employee1.getImage_bytes());
            employee1.setExperience(employee.getExperience());
            employee1.setFullName(employee.getFullName());
            employee1.setPhone(employee.getPhone());
            employee1.setPosition1(employee.getPosition1());
            employee1.setSalary(employee.getSalary());
            employee1.setEmail(employee.getEmail());
            employeeRepository.save(employeeRepository.findById(id).orElseThrow());
        }

    }

}