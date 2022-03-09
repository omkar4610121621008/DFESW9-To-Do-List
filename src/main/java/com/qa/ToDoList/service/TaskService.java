package com.qa.ToDoList.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.ToDoList.domain.Task;
import com.qa.ToDoList.domain.User;
import com.qa.ToDoList.repo.TaskRepository;
import com.qa.ToDoList.repo.UserRepository;
@Service
public class TaskService {
	@Autowired
	private TaskRepository taskrepo;
	
	@Autowired
	private UserRepository userrepo;
	
	public List<Task> getAllTasksByUserId(Long id){
		List<Task> tasks = new ArrayList<Task>();
		taskrepo.findByUserId(id).forEach(tasks::add);
		return tasks;
	}

	public Task createTask(Task model) {
		return this.taskrepo.save(model);
	}
	
	public Task updateTask(long id, Task model) {
		Optional<Task> T = this.taskrepo.findById(id);//MAYBE ADD OR ELSE THROWS
		Task exists = T.orElseThrow();
		exists.setId(model.getId());
		exists.setDescription(model.getDescription());
		exists.setCompleted(model.getCompleted());
		return this.taskrepo.save(exists);//ask if we need id of foreign key
	}
	
	public List<Task> readAllTasks() {
		return this.taskrepo.findAll();//MAYBE WORK ON THIS
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
		User user = userrepo.findById(userId).get();
		task.setUser(user);
		return this.taskrepo.save(task);
	}
	

}
