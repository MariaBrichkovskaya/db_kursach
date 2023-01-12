package com.db.kursach.services;

import com.db.kursach.models.Employee;
import com.db.kursach.repositories.EmployeeRepository;
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
    private final EmployeeRepository employeeRepository;

    public List<Employee> listEmployees(String fullName){
        if(fullName!=null) return employeeRepository.findByFullNameContaining(fullName);
        return employeeRepository.findAll();
    }
    public void saveEmployee(Employee employee) throws IOException {
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

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }
    public void editEmployee(Long id, Employee employee){
        Employee employee1=employeeRepository.findById(id).orElseThrow();
        employee1.setDate(employee1.getDate());
        employee1.setImage_bytes(employee1.getImage_bytes());
        employee1.setExperience(employee.getExperience());
        employee1.setFullName(employee.getFullName());
        employee1.setPhone(employee.getPhone());
        employee1.setPosition1(employee.getPosition1());
        employee1.setSalary(employee.getSalary());
        employeeRepository.save(employeeRepository.findById(id).orElse(null));
    }

}
