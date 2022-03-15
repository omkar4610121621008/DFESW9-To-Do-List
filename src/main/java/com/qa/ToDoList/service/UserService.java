package com.qa.ToDoList.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qa.ToDoList.domain.TaskUser;
import com.qa.ToDoList.repo.UserRepository;


@Service
public class UserService {
	
	private UserRepository repo;
	
	@Autowired
	public UserService(UserRepository repo) {
		this.repo = repo;
	}
	
	public TaskUser createUser(TaskUser model) {
		return this.repo.save(model);
	}

	public TaskUser updateUser(long id, TaskUser model) {
		Optional<TaskUser> T = this.repo.findById(id);
		TaskUser exists = T.orElseThrow();
		exists.setName(model.getName());
		return this.repo.save(exists);
	}
	
	public List<TaskUser> readAll() {
		return this.repo.findAll();
	}

	public TaskUser readByUserId(long id) {
		return this.repo.findById(id).orElseThrow();
	}
	
	public boolean deleteUser(long id) {
		Optional<TaskUser> userExists = this.repo.findById(id);
		
		if (userExists.isPresent()) {
			this.repo.deleteById(id);
			return !(this.repo.existsById(id));
		}
		return false;
	}
	
}
	
	
		
		
	

