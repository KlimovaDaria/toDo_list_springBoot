package com.example.toDo_list_springBoot.controller;

import com.example.toDo_list_springBoot.entity.User;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import java.util.List;

public interface UserController {
    List<User> getAllUsers();
    User updateUser(User user, BindingResult bindingResult);
    User getUser(int id);
    User addUser(User user, BindingResult bindingResult);
    String deleteUser(int id);
}
