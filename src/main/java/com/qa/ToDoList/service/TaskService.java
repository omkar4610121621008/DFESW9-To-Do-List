package com.qa.ToDoList.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.ToDoList.domain.Task;
import com.qa.ToDoList.domain.TaskUser;
import com.qa.ToDoList.repo.TaskRepository;
import com.qa.ToDoList.repo.UserRepository;
@Service
public class TaskService {
	@Autowired
	private TaskRepository taskrepo;
	
	@Autowired
	private UserRepository userrepo;

	public Task createTask(Task model) {
		return this.taskrepo.save(model);
	}
	
	public Task updateTask(long id, Task model) {
		Optional<Task> T = this.taskrepo.findById(id);
		Task exists = T.orElseThrow();
		exists.setDescription(model.getDescription());
		exists.setCompleted(model.getCompleted());
		return this.taskrepo.save(exists);
	}
	
	public List<Task> readAllTasks() {
		return this.taskrepo.findAll();
	}

	public Task readByTaskId(long id) {
		return this.taskrepo.findById(id).orElseThrow();
	}
	
	public boolean deleteTask(long id) {
		Optional<Task> taskExists = this.taskrepo.findById(id);
		
		if (taskExists.isPresent()) {
			this.taskrepo.deleteById(id);
			return !(this.taskrepo.existsById(id));
		}
		return false;
	}
	
	public Task assignTask(Long taskId, Long userId) {
		Task task = taskrepo.findById(taskId).get();
		TaskUser user = userrepo.findById(userId).get();
		task.setUser(user);
		return this.taskrepo.save(task);
	}
	

}
