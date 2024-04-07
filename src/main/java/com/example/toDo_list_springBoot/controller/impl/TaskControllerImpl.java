package com.example.toDo_list_springBoot.controller.impl;

import com.example.toDo_list_springBoot.controller.TaskController;
import com.example.toDo_list_springBoot.entity.Task;
import com.example.toDo_list_springBoot.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskControllerImpl implements TaskController {
    @Autowired
    private TaskService taskService;
    @Override
    @GetMapping("/tasksByUser/{userId}")
    public List<Task> getAllTasks(@PathVariable("userId") int userId) {
        List<Task> tasks = taskService.getAllTasks(userId);
        System.out.println(tasks);
        return tasks;
    }

    @Override
    @GetMapping("/tasks/{id}")
    public Task getTask(@PathVariable("id") int id) {
        return taskService.getTask(id);
    }

    @Override
    @PutMapping("/tasksByUser/{userId}")
    public Task updateTask(@RequestBody Task task, @PathVariable("userId") int userId) {
        return taskService.saveTask(task, userId);
    }

    @Override
    @PostMapping("/tasksByUser/{userId}")
    public Task addTask(@RequestBody Task task, @PathVariable("userId") int userId) {
        System.out.println(task.getUser());
        return taskService.saveTask(task, userId);
    }

    @Override
    @DeleteMapping("/tasks/{id}")
    public String deleteTask(@PathVariable("id") int id) {
        Task task = taskService.getTask(id);
        taskService.deleteTask(id);
        return "task "+ task.toString()+" was deleted";
    }
}
