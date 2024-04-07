package com.example.toDo_list_springBoot.repository;

import com.example.toDo_list_springBoot.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Integer> {
}
