package com.db.kursach.services;

import com.db.kursach.enums.Role;
import com.db.kursach.models.User;
import com.db.kursach.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    public boolean createUser(User user){
        if(userRepository.findByLogin(user.getLogin())!=null){
            return false;
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.ROLE_DIRECTOR);
        log.info("Saving new user with login {}",user.getLogin());
        userRepository.save(user);
        return true;
    }
}
