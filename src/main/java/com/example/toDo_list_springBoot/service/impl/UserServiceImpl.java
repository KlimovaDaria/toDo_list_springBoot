package com.example.toDo_list_springBoot.service.impl;

import com.example.toDo_list_springBoot.entity.Task;
import com.example.toDo_list_springBoot.repository.UserRepository;
import com.example.toDo_list_springBoot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.toDo_list_springBoot.entity.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    @Override
    public User getUser(int id) {
        return userRepository.findById(id).orElse(null);
    }
    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }
    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<Task> getAllTasks(int id) {
        User user = userRepository.findById(id).orElse(null);
        if (user!=null) {
            return user.getTasks();
        }
        return null;
    }
}
