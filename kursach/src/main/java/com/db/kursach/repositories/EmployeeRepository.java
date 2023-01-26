package com.db.kursach.repositories;

import com.db.kursach.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    List<Employee> findByFullNameContaining(String fullName);

    Employee findByEmail(String email);
}
