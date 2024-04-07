package com.example.toDo_list_springBoot.service;


import com.example.toDo_list_springBoot.entity.Task;

import java.util.List;

public interface TaskService {
    List<Task> getAllTasks(int userId);
    Task getTask(int id);
    Task saveTask(Task task, int userId);
    void deleteTask(int id);
}
