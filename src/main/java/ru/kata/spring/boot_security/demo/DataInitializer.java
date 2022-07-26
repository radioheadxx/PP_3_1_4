package ru.kata.spring.boot_security.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.entity.Role;
import ru.kata.spring.boot_security.demo.entity.User;
import ru.kata.spring.boot_security.demo.repository.RoleRepository;
import ru.kata.spring.boot_security.demo.service.UserService;

//import javax.annotation.PostConstruct;
//import java.util.ArrayList;
//import java.util.List;
//
//@Component
//public class DataInitializer {
//    @Autowired
//    UserService userService;
//    @Autowired
//    PasswordEncoder bCryptPasswordEncoder;
//    @Autowired
//    RoleRepository roleRepository;
//
//
//    @PostConstruct
//    void init() {
//        Role userRole = new Role("ROLE_ADMIN");
//        Role adminRole = new Role( "ROLE_USER");
//
//        roleRepository.save(userRole);
//        roleRepository.save(adminRole);
//
//        List<Role> roles = new ArrayList<>();
//
//        roles.add(userRole);
//        roles.add(adminRole);
//
//        User user = new User("Ash", "Links", 18, "wildcat@mail.com", "11", roles);
//        User user2 = new User("eidji", "weak", 17, "softboy@mail.com", "22", roles);
//
//        userService.saveUser(user);
//        userService.saveUser(user2);
//
//    }
//}