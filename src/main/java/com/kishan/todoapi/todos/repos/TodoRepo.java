package com.kishan.todoapi.todos.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.kishan.todoapi.todos.beans.Todo;

public interface  TodoRepo extends CrudRepository<Todo, Integer>{
	
	List<Todo> findByUserId(int userId);
	
	Todo findByTodoNameAndUserId(String todoName,int userId);

}
