package com.qa.ToDoList.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.ToDoList.domain.User;
import com.qa.ToDoList.repo.UserRepository;


@Service
public class UserService {
	
	private UserRepository repo;
	
	@Autowired
	public UserService(UserRepository repo) {
		this.repo = repo;
	}
	
	public User create(User model) {
		return this.repo.save(model);
	}
	
	public User update(long id, User model) {
		Optional<User> T = this.repo.findById(id);//MAYBE ADD OR ELSE THROWS
		User exists = T.orElseThrow();
		exists.setName(model.getName());
		return this.repo.save(exists);
	}
	
	public List<User> readAll() {
		return this.repo.findAll();//MAYBE WORK ON THIS
	}

	public User readById(long id) {
		return this.repo.findById(id).orElseThrow();
	}
	
	public boolean delete(long id) {
		Optional<User> userExists = this.repo.findById(id);
		
		if (userExists.isPresent()) {
			this.repo.deleteById(id);
			return !(this.repo.existsById(id));
		}
		return false;
	}
		
		
	

}
