package com.example.toDo_list_springBoot.controller;

import com.example.toDo_list_springBoot.entity.Task;

import java.util.List;

public interface TaskController {
    List<Task> getAllTasks(int userId);
    Task getTask(int id);
    Task updateTask(Task task, int userId);
    Task addTask(Task task, int userId);
    String deleteTask(int id);
}
