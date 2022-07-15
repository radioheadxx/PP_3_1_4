package ru.kata.spring.boot_security.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.entity.Role;
import ru.kata.spring.boot_security.demo.entity.User;
import ru.kata.spring.boot_security.demo.service.UserService;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataInitializer {
    @Autowired
    UserService userService;
    @Autowired
    PasswordEncoder bCryptPasswordEncoder;

    @PostConstruct
    void init() {
        Role userRole = new Role("ROLE_ADMIN");
        Role adminRole = new Role( "ROLE_USER");
        userService.addRole(adminRole);
        userService.addRole(userRole);
        List<Role> roles = new ArrayList<>();
        roles.add(userRole);
        roles.add(adminRole);
        User user = new User("Ash", "Links", "wildcat@mail.com", "qwerty", roles);
        userService.saveUser(user);
    }
}