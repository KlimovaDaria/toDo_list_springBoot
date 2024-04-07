package com.example.toDo_list_springBoot.service;

import com.example.toDo_list_springBoot.entity.Task;
import com.example.toDo_list_springBoot.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUser(int id);
    User saveUser(User user);
    void deleteUser(int id);

    List<Task> getAllTasks(int id);
}
