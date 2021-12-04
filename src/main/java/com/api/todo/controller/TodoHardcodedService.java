package com.api.todo.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.api.todo.controller.entity.TodoList;


// getall
@Service
public class TodoHardcodedService {
	private static List<TodoList> todos = new ArrayList<>();
	private static long idCounter = 0;
	static {
		todos.add(new TodoList(++idCounter, "Admin", "Hangout alone", true, new Date()));
		todos.add(new TodoList(++idCounter, "User", "Go to sleep", true, new Date()));
		todos.add(new TodoList(++idCounter, "Joshua", "Learn to code", true, new Date()));
	}
	
	public List<TodoList>findAll() {
		return todos;
	}
	
	public TodoList deleteById(long id) {
		TodoList todo = findById(id);
		
		if(todo == null) return null; // if id is null return
		
		if(todos.remove(todo)) {
			return todo;
		}
		return null;
		
	}
	public TodoList findById(long id) {
		for(TodoList todo: todos) {
			if(todo.getId() == id) {
				return todo;
			}
		}
		return null;
	}
	
	//update/save
	//delete the 
//	public todoList save(todoList todo) {
//		if(todo.getId()==-1 && todo.getId()==0) {
//			todo.setId(++idCounter);
//			todos.add(todo);
//		
//		} else {
//			// update delete first then save
//			deleteById(todo.getId());
//			todos.add(todo);
//			
//		}
//		return todo;
//	}
//	return todo;
	public TodoList save(TodoList todo) {
			todo.setId(++idCounter);
			todos.add(todo);
		
		return todo;
	}
	
	public TodoList update(TodoList todo) {
		deleteById(todo.getId());
		todos.add(todo);
		
		return todo;
	}

}
