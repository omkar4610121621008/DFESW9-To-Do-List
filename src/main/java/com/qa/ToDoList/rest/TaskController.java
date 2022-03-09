package com.qa.ToDoList.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.ToDoList.domain.Task;
import com.qa.ToDoList.service.TaskService;

@RestController
public class TaskController {
	
	private TaskService taskservice;
	
	@Autowired
	public TaskController(TaskService taskservice) {
		this.taskservice = taskservice;
	}
	
	
	@GetMapping("/task/all")
	public ResponseEntity<List<Task>> readAllTasks() {
	  return new ResponseEntity<>(this.taskservice.readAllTasks(), HttpStatus.OK);
	}
	
	@GetMapping("/task/{id}")
	public ResponseEntity<Task> getTaskById(@PathVariable long id) {
	  return new ResponseEntity<>(this.taskservice.readByTaskId(id), HttpStatus.OK);
	}
	
	@PostMapping("/task")
	public ResponseEntity<Task> createTask(@RequestBody Task body) {
	    return new ResponseEntity<>(this.taskservice.createTask(body), HttpStatus.CREATED);
	}

	@PutMapping("/task-update/{id}")
	public ResponseEntity<Task> updateTaskById(@PathVariable long id, @RequestBody Task body) {
		return new ResponseEntity<>(this.taskservice.updateTask(id, body), HttpStatus.OK);
	}

	@DeleteMapping("/delete-task/{id}")
    public ResponseEntity<HttpStatus> deleteTaskById(@PathVariable long id) {
	    return new ResponseEntity<>(this.taskservice.deleteTask(id) ? HttpStatus.NO_CONTENT: HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@RequestMapping("/user/{id}/tasks")
	public ResponseEntity<List<Task>> getAllTasksById(@PathVariable Long id) {
	  return new ResponseEntity<>(this.taskservice.getAllTasksByUserId(id), HttpStatus.OK);
	}

}
