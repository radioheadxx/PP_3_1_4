package ru.kata.spring.boot_security.demo.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.entity.Role;
import ru.kata.spring.boot_security.demo.entity.User;
import ru.kata.spring.boot_security.demo.forms.UserFormCreateApi;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRestController {

    private final UserService userService;

    public MyRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public User getOneUser(@PathVariable("id") Long id) {
        return userService.findById(id);
    }

//    @PostMapping
//    public User createNewUser(@RequestBody User user) {
//        System.out.println();
//        System.out.println();
//        System.out.println( "Мой юзер ----------------------------- " + user);
//        System.out.println();
//        System.out.println();
////        user.setRoles(userService.findRolesByName(user.getRoles()));
//        userService.saveUser(user);
//        return user;
//    }

    @PostMapping()
    public UserFormCreateApi createNewUser(@RequestBody UserFormCreateApi user) {

        User newUser = User.builder()
                .username(user.getUsername())
                .surname(user.getSurname())
                .email(user.getEmail())
                .age(user.getAge())
                .password(user.getPassword())
                .build();

        newUser.setRoles(userService.findRolesByName(user.getRoles()));
        System.out.println("---------------------------------------------"+newUser);
        userService.saveUser(newUser);
        return user;
    }

    @PutMapping
    public UserFormCreateApi updateUser(@RequestBody UserFormCreateApi user) {
        User newUser = User.builder()
                .id(user.getId())
                .username(user.getUsername())
                .surname(user.getSurname())
                .email(user.getEmail())
                .age(user.getAge())
                .password(user.getPassword())
                .build();
        newUser.setRoles(userService.findRolesByName(user.getRoles()));
        System.out.println("---------------------------------------------"+newUser);
        userService.update(newUser);
        return user;
    }
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUserById(id);
        return "OK";
    }
}
