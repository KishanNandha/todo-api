package com.kishan.todoapi.users.repos;

import org.springframework.data.repository.CrudRepository;

import com.kishan.todoapi.todos.beans.UserBean;

public interface UserRepo extends CrudRepository<UserBean, Integer>{

	UserBean findByUserName(String username);
}
