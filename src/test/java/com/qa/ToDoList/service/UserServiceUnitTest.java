package com.qa.ToDoList.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.qa.ToDoList.domain.User;
import com.qa.ToDoList.repo.UserRepository;


public class UserServiceUnitTest {
	
	@InjectMocks
	private UserService userservice;
	
	@Mock
	private UserRepository userrepo;

	
	@Test
	void testingUserCreate() {
		User user = new User(1L, "John");
		
		when(userrepo.save(Mockito.any(User.class))).thenReturn(user);
		
		User expect = this.userservice.createUser(user);
		
		assertThat(expect).isEqualTo(user);
		
		Mockito.verify(this.userrepo, Mockito.times(1)).save(Mockito.any(User.class));
	
	}

}
