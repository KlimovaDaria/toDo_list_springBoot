package com.example.toDo_list_springBoot.service.impl;

import com.example.toDo_list_springBoot.entity.User;
import com.example.toDo_list_springBoot.repository.TaskRepository;
import com.example.toDo_list_springBoot.repository.UserRepository;
import com.example.toDo_list_springBoot.service.TaskService;
import com.example.toDo_list_springBoot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.toDo_list_springBoot.entity.Task;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserService userService;

    @Override
    public List<Task> getAllTasks(int userId) {
        return userService.getAllTasks(userId);
    }

    @Override
    public Task getTask(int id) {
        return taskRepository.findById(id).orElse(null);
    }

    @Override
    public Task saveTask(Task task, int userId) {
        User user = userService.getUser(userId);
        if (user!=null) {
            user.addTask(task);
            taskRepository.save(task);
            return task;
        }
        return null;
    }

    @Override
    public void deleteTask(int id) {
        taskRepository.deleteById(id);
    }
}
