package com.qa.ToDoList.rest;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.qa.ToDoList.domain.User;
import com.qa.ToDoList.service.UserService;

public class UserControllerUnitTest {
	
	@MockBean
	private UserService service;
	
	@Autowired
	private UserController controller;
	
	@Test
	public void createUserTest() {
		User user = new User(100L, "Omkar");
		Mockito.when(this.service.createUser(user)).thenReturn(user);
		
		ResponseEntity<User> omkar = this.controller.createUser(user);
		assertThat(omkar).isEqualTo(new ResponseEntity<User>(user, HttpStatus.CREATED));
		
	//	Mockito.verify(this.service, Mockito.times(1)).createUser();
	}
	
	@Test
	public void readAllUsersTest() {
		User user = new User(100L, "Omkar");
		User john = new User(101L, "John");
		List<User> users = new ArrayList<User>();
		users.add(user);
		users.add(john);

		Mockito.when(this.service.readAll()).thenReturn(users);

		ResponseEntity<List<User>> same = new ResponseEntity<List<User>>(users, HttpStatus.OK);

		assertThat(same).isEqualTo(controller.readAllUsers());
		
		Mockito.verify(this.service, Mockito.times(1)).readAll();
		
	}
	
	@Test
	public void readByIdTest() {
		User john = new User(108L, "John");
		
		Mockito.when(this.service.readByUserId(john.getId())).thenReturn(john);
		
		ResponseEntity<User> another = new ResponseEntity<User>(john, HttpStatus.OK);
		
		assertThat(another).isEqualTo(controller.getUserById(john.getId()));
		
		Mockito.verify(this.service, Mockito.times(1)).readByUserId(john.getId());
	}
	
	@Test
	public void deleteUserTest() {
		
		User john = new User(110L, "John");
		
		Mockito.when(this.service.deleteUser(john.getId())).thenReturn(true);
		
        ResponseEntity<Boolean> bool = new ResponseEntity<Boolean>(true, HttpStatus.NO_CONTENT);
		
		assertThat(bool).isEqualTo(controller.deleteUser(john.getId()));
		
		Mockito.verify(this.service, Mockito.times(1)).deleteUser(john.getId());
	}
	
	@Test
	public void updateUserTest() {
		
		User omkar = new User(111L, "Omkar");
		User john = new User("John");
		
		Mockito.when(this.service.updateUser(omkar.getId(), john)).thenReturn(john);
		
		ResponseEntity<User> anotherone = new ResponseEntity<User>(john, HttpStatus.OK);//MAYBE WORK ON THIS???
		
		assertThat(anotherone).isEqualTo(controller.updateUser(omkar.getId(), john));
		
		Mockito.verify(this.service, Mockito.times(1)).updateUser(omkar.getId(), john);
		
	}
	
	
	
	
	

}
