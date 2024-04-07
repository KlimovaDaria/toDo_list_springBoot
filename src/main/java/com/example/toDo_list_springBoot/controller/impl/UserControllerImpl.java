package com.example.toDo_list_springBoot.controller.impl;
import com.example.toDo_list_springBoot.entity.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.toDo_list_springBoot.service.*;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserControllerImpl implements com.example.toDo_list_springBoot.controller.UserController {
    @Autowired
    private UserService userService;

    @Override
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @Override
    @PutMapping("/users")
    public User updateUser(@RequestBody User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.hasErrors());
            return null;
        }
        return userService.saveUser(user);
    }

    @Override
    @GetMapping("/users/{id}")
    public User getUser(@PathVariable("id") int id) {
        return userService.getUser(id);
    }

    @Override
    @PostMapping("/users")
    public User addUser(@Valid @RequestBody User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.hasErrors());
                return null;
        }
        return userService.saveUser(user);
    }

    @Override
    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        User user = getUser(id);
        userService.deleteUser(id);
        return "user "+user.toString()+" was deleted";
    }
}
