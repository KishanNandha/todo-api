package com.kishan.todoapi.todos.beans;

import javax.validation.constraints.NotNull;

public class TodoRequestBean {

	@NotNull
	private String userName;
	
	private String todoName;

	public TodoRequestBean() {
		super();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getTodoName() {
		return todoName;
	}

	public void setTodoName(String todoName) {
		this.todoName = todoName;
	}

	
}
