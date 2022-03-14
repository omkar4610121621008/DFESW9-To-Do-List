package com.qa.ToDoList.rest;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.qa.ToDoList.domain.TaskUser;
import com.qa.ToDoList.service.UserService;
@SpringBootTest
public class UserControllerUnitTest {
	
	@MockBean
	private UserService service;
	
	@Autowired
	private UserController controller;
	
	@Test
	public void createUserTest() {
		TaskUser user = new TaskUser(100L, "Omkar");
		Mockito.when(this.service.createUser(user)).thenReturn(user);
		
		ResponseEntity<TaskUser> omkar = this.controller.createUser(user);
		assertThat(omkar).isEqualTo(new ResponseEntity<TaskUser>(user, HttpStatus.CREATED));
		
	//	Mockito.verify(this.service, Mockito.times(1)).createUser();
	}
	
	@Test
	public void readAllUsersTest() {
		TaskUser user = new TaskUser(100L, "Omkar");
		TaskUser john = new TaskUser(101L, "John");
		List<TaskUser> users = new ArrayList<TaskUser>();
		users.add(user);
		users.add(john);

		Mockito.when(this.service.readAll()).thenReturn(users);

		ResponseEntity<List<TaskUser>> same = new ResponseEntity<List<TaskUser>>(users, HttpStatus.OK);

		assertThat(same).isEqualTo(controller.readAllUsers());
		
		Mockito.verify(this.service, Mockito.times(1)).readAll();
		
	}
	
	@Test
	public void readByIdTest() {
		TaskUser john = new TaskUser(108L, "John");
		
		Mockito.when(this.service.readByUserId(john.getId())).thenReturn(john);
		
		ResponseEntity<TaskUser> another = new ResponseEntity<TaskUser>(john, HttpStatus.OK);
		
		assertThat(another).isEqualTo(controller.getUserById(john.getId()));
		
		Mockito.verify(this.service, Mockito.times(1)).readByUserId(john.getId());
	}
	
	@Test
	public void deleteUserTest() {
		
		TaskUser john = new TaskUser(110L, "John");
		
		Mockito.when(this.service.deleteUser(john.getId())).thenReturn(true);
		
        ResponseEntity<Boolean> bool = this.controller.deleteUser(john.getId());
		
		assertThat(bool).isEqualTo(new ResponseEntity<Boolean>(HttpStatus.NO_CONTENT));
		
		Mockito.verify(this.service, Mockito.times(1)).deleteUser(john.getId());
	}
	
	@Test
	public void updateUserTest() {
		
		TaskUser omkar = new TaskUser(111L, "Omkar");
		TaskUser john = new TaskUser("John");
		
		Mockito.when(this.service.updateUser(omkar.getId(), john)).thenReturn(john);
		
		ResponseEntity<TaskUser> anotherone = new ResponseEntity<TaskUser>(john, HttpStatus.OK);//MAYBE WORK ON THIS???
		
		assertThat(anotherone).isEqualTo(controller.updateUser(omkar.getId(), john));
		
		Mockito.verify(this.service, Mockito.times(1)).updateUser(omkar.getId(), john);
		
	}
	
	
	
	
	

}
