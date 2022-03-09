package com.qa.ToDoList.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.qa.ToDoList.repo.TaskRepository;
import com.qa.ToDoList.repo.UserRepository;

@RestController
public class UserTaskController {
	
	@Autowired
	private UserRepository userrepo;
	
	@Autowired
	private TaskRepository taskrepo;
	
	
	
	

}
