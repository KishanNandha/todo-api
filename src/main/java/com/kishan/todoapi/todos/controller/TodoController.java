package com.kishan.todoapi.todos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kishan.todoapi.exception.TodoNotFoundException;
import com.kishan.todoapi.exception.UserNotFoundException;
import com.kishan.todoapi.todos.beans.Todo;
import com.kishan.todoapi.todos.beans.TodoRequestBean;
import com.kishan.todoapi.todos.beans.UserBean;
import com.kishan.todoapi.todos.repos.TodoRepo;
import com.kishan.todoapi.users.repos.UserRepo;

@CrossOrigin
@RestController
public class TodoController {
	
	@Autowired
	private TodoRepo todoRepo;
	
	@Autowired
	private UserRepo userRepo;
	
	@PostMapping("/todos/getAll")
	private List<Todo> getTodosForUser(@RequestBody TodoRequestBean todoRequestBean) {
		
		UserBean user = userRepo.findByUserName(todoRequestBean.getUserName());
		if(null == user) {
			throw new UserNotFoundException("User with username "+todoRequestBean.getUserName()+" not found");
		}
		
		
		List<Todo> users = todoRepo.findByUserId(user.getUserId());
		if(null == users) {
			throw new TodoNotFoundException("Sorry, we cant find any todo's");
		}
		
		return users;
	}
	
	@PostMapping("/todos/retrieve")
	private Todo getTodoDetails(@RequestBody TodoRequestBean todoRequestBean) {
		
		UserBean user = userRepo.findByUserName(todoRequestBean.getUserName());
		if(null == user) {
			throw new UserNotFoundException("User with username "+todoRequestBean.getUserName()+" not found");
		}
		
		Todo todo= todoRepo.findByTodoNameAndUserId(todoRequestBean.getTodoName(), user.getUserId());
		if(null == todo) {
			throw new TodoNotFoundException("Sorry, we cant find any todo's");
		}
		
		return todo;
	}

}
