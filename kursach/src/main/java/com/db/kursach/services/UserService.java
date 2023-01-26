package com.db.kursach.services;

import com.db.kursach.enums.Role;
import com.db.kursach.models.Employee;
import com.db.kursach.models.User;
import com.db.kursach.repositories.EmployeeRepository;
import com.db.kursach.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final EmployeeRepository employeeRepository;
    private final PasswordEncoder passwordEncoder;
    public boolean createUser(User user){
        if(userRepository.findByEmail(user.getEmail())!=null || employeeRepository.findByEmail(user.getEmail())==null){
            return false;
        }
        Employee employee = employeeRepository.findByEmail(user.getEmail());
        user.setEmployee(employee);
        switch (Math.toIntExact(employee.getPosition1().getId())){
            case 1: user.setRole(Role.ROLE_DIRECTOR); break;
            case 2,6: user.setRole(Role.ROLE_ADMINISTRATOR); break;
            case 3,4,7: user.setRole(Role.ROLE_WAITER); break;
            case 5: user.setRole(Role.ROLE_ACCOUNTANT); break;
            default: user.setRole(Role.ROLE_WAITER); break;
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        log.info("Saving new user with login {}",user.getEmail());
        userRepository.save(user);
        return true;
    }

    public User getUserByPrincipal(Principal principal) {
        if(principal==null)return new User();
        return userRepository.findByEmail(principal.getName());
    }
}
