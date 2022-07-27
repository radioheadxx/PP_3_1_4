package ru.kata.spring.boot_security.demo.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.entity.User;
import ru.kata.spring.boot_security.demo.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public String showAllUsers(Model model, @AuthenticationPrincipal User currentUser) {
        model.addAttribute("allUs", userService.getAllUsers());
        model.addAttribute("currentUser", currentUser);
        model.addAttribute("roles", userService.getAllRoles());
        return "all_users";
    }

    @PostMapping("/update")
    public String updateUser(@ModelAttribute("user") User user, @RequestParam(value = "role") String role) {
        user.setRoles(userService.findRolesByName(role));
        userService.update(user);
        return "redirect:/admin";
    }

//    @GetMapping("/create")
//    public String createUserForm(Model model) {
//        User user = new User();
//        model.addAttribute("user", user);
//        model.addAttribute("roles", userService.getAllRoles());
//        return "user-create";
//    }
//
    @PostMapping("/create")
    public String createUser(@ModelAttribute("user") User user, @RequestParam(value = "role") String role) {
        user.setRoles(userService.findRolesByName(role));
        userService.saveUser(user);
        return "redirect:/admin";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUserById(id);
        return "redirect:/admin";
    }


}