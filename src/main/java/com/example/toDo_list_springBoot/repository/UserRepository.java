package com.example.toDo_list_springBoot.repository;

import com.example.toDo_list_springBoot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
