package com.api.todo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.todo.controller.entity.TodoList;

@Repository
public interface TodoRepository extends JpaRepository<TodoList, Long>{

	List<TodoList>findByUsername(String username);
}
