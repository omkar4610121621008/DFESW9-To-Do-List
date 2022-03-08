package com.qa.ToDoList.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.ToDoList.domain.Task;
import com.qa.ToDoList.service.TaskService;

@RestController
public class TaskController {
	
	@Autowired
	private TaskService taskservice;
	
	@RequestMapping("/user/{id}/tasks")
	public List<Task> getAllTasksById(@PathVariable Long id){
		return taskservice.getAllTasksByUserId(id);
	}

}
