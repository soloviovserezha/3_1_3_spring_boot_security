package ru.kata.spring.boot_security.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.entities.User;
import ru.kata.spring.boot_security.demo.services.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.getUserList());
        return "users";
    }

    @GetMapping("/users/{id}")
    public String getUserById(@PathVariable(value = "id") Long id, Model model) {
        model.addAttribute("user_id", userService.getUserById(id));
        return "users-details";
    }

    @GetMapping("/users/add")
    public String saveUser(Model model) {
        model.addAttribute("userForm", new User());
        userService.getUserList();
        return "user-add";
    }

    @PostMapping("/users/add")
    public String saveUserPost(User user) {
        userService.saveUser(user);
        return "redirect:/admin/users";
    }

    @GetMapping("/users/{id}/edit")
    public String editUser(@PathVariable(value = "id") Long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "user-edit";
    }

    @PatchMapping(value = "/users/{id}/edit")
    public String changeUser(User user, Model model) {
        model.addAttribute("user", userService.changeUser(user));
        return "redirect:/admin/users";
    }

    @DeleteMapping("/users/{id}/remove")
    public String deleteUserById(@PathVariable(value = "id") Long id, Model model) {
        model.addAttribute("id", userService.deleteUserById(id));
        return "redirect:/admin/users";
    }

    @DeleteMapping("/users/remove")
    public String deleteAllUsers() {
        userService.deleteAllUsers();
        return "redirect:/admin/users";
    }
}
