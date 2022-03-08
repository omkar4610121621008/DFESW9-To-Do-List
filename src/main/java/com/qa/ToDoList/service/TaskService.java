package com.qa.ToDoList.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.qa.ToDoList.domain.Task;
import com.qa.ToDoList.repo.TaskRepository;

public class TaskService {
	
	private TaskRepository repo;
	
	@Autowired
	public TaskService(TaskRepository repo) {
		this.repo = repo;
	}
	
	public List<Task> getAllTasksByUserId(Long id){
		List<Task> tasks = new ArrayList<Task>();
		repo.findByUserId(id).forEach(tasks::add);
		return tasks;
	}

	public Task createTask(Task model) {
		return this.repo.save(model);
	}
	
	public Task updateTask(long id, Task model) {
		Optional<Task> T = this.repo.findById(id);//MAYBE ADD OR ELSE THROWS
		Task exists = T.orElseThrow();
		exists.setId(model.getId());
		exists.setDescription(model.getDescription());
		exists.setCompleted(model.getCompleted());
		return this.repo.save(exists);//ask if we need id of foreign key
	}
	
	public List<Task> readAllTasks() {
		return this.repo.findAll();//MAYBE WORK ON THIS
	}

	public Task readByTaskId(long id) {
		return this.repo.findById(id).orElseThrow();
	}
	
	public boolean deleteTask(long id) {
		Optional<Task> taskExists = this.repo.findById(id);
		
		if (taskExists.isPresent()) {
			this.repo.deleteById(id);
			return !(this.repo.existsById(id));
		}
		return false;
	}
	

}
