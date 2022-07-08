package ru.kata.spring.boot_security.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kata.spring.boot_security.demo.entity.User;
import ru.kata.spring.boot_security.demo.service.UserService;

@Controller
@RequestMapping("/users")
public class UsersController {

    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String showAllUsers(Model model) {
        model.addAttribute("allUs", userService.getAllUsers());
        return "all-users";
    }

    @GetMapping("create")
    public String createUserForm(User user) {
        return "user-create";
    }

    @PostMapping("create")
    public String createUser(User user) {
        userService.saveUser(user);
        return "redirect:/users/";
    }

    @GetMapping("delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUserById(id);
        return "redirect:/users/";
    }

    @GetMapping("update{id}")
    public String updateUserForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute(userService.findById(id));
        return "user-update";
    }

    @PostMapping("update")
    public String updateUser(User user) {
        userService.saveUser(user);
        return "redirect:/users/";
    }
}
