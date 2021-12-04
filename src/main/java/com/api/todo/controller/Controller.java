package com.api.todo.controller;

import com.api.todo.controller.entity.TodoList;
import com.api.todo.repository.TodoRepository;

import java.net.URI;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;



@CrossOrigin(origins="http://localhost:4200")
@RestController
public class Controller {

	@GetMapping(path="hello-world")
	public String hellowWorld() {
		return "Hello springboot";
	}
	
//	@GetMapping(path="todo-list")
//	public todoList todo() {
////		throw new RuntimeException("Something went wrong here in the server");
//		return new todoList(,"admin", "Go somewhere",true, new Date());
//	}
	// localhost:8080/todo-list/description
//	@GetMapping(path="todo-list/{description}")
//	public todoList todoDescription(@PathVariable String description) {
//		return new todoList(1, String.format("Username: %s ", description ),"Go somewhere", true, new Date());
//	}
	
	

	@Autowired
	private TodoHardcodedService todoService;
	
	@Autowired
	private TodoRepository todoRepository;
	
	// get all
	// http://localhost:8080/users/username/todo-list
	@GetMapping(path="/users/{username}/todo-list")
	public List<TodoList> getAllTodos(@PathVariable String username) {
		return todoRepository.findAll();
//		return todoService.findAll();
	}
	
	// get by id
	// http://localhost:8080/users/admin/todo-list/1
	@GetMapping(path="/users/{username}/todo-list/{id}")
	public TodoList getTodo(@PathVariable String username, @PathVariable long id) {
		return todoRepository.findById(id).get();
//		return todoService.findById(id);
	}
	
	// delete by id
	// http://localhost:8080/users/admin/todo-list/1
	@DeleteMapping(path="/users/{username}/todo-list/{id}")
	public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable long id) {
		// involk the deleteby id in service and return todo if successful
		// otherwise will return a not found status
//		TodoList todo = todoService.deleteById(id);
		todoRepository.deleteById(id);
//		if(todo!=null) {
//			return ResponseEntity.noContent().build();
//		}
//		return ResponseEntity.notFound().build();
		return ResponseEntity.noContent().build();
	}
	
	// update
	//http://localhost:8080/users/admin/todo-list/2
	@PutMapping(path="/users/{username}/todo-list/{id}")
	public ResponseEntity<TodoList> updateTodo(
			@PathVariable String username,
			@PathVariable long id,
			@RequestBody TodoList todo) {
//			TodoList todoUpdated = todoService.update(todo);
			TodoList todoUpdated = todoRepository.save(todo);
			return new ResponseEntity<TodoList>(todo, HttpStatus.OK);
		}

	// add body should not have an id
	// http://localhost:8080/users/admin/todo-list
	@PostMapping(path="/users/{username}/todo-list")
	public ResponseEntity<Void> addTodo(
			@PathVariable String username,
			@RequestBody TodoList todo) {
//			TodoList createdTodo = todoService.save(todo);
			TodoList createdTodo = todoRepository.save(todo);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
					.path("/{id}")
					.buildAndExpand(createdTodo.getId()).toUri();
			return ResponseEntity.created(uri).build();
			}
	
	
}
