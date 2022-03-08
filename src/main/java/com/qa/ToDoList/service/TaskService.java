package com.qa.ToDoList.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.qa.ToDoList.repo.TaskRepository;

public class TaskService {
	
	private TaskRepository repo;
	
	@Autowired
	public TaskService(TaskRepository repo) {
		this.repo = repo;
	}

}
