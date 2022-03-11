package com.qa.ToDoList.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.qa.ToDoList.domain.User;
import com.qa.ToDoList.repo.UserRepository;

//ANNOTATIONS????
public class UserServiceUnitTest {
	
	@InjectMocks
	private UserService userservice;
	
	@Mock
	private UserRepository userrepo;

	
	@Test
	public void testingCreateUser() {
		User user = new User(1L, "John");
		
		when(userrepo.save(Mockito.any(User.class))).thenReturn(user);
		
		User expect = this.userservice.createUser(user);
		
		assertThat(expect).isEqualTo(user);
		
		Mockito.verify(this.userrepo, Mockito.times(1)).save(Mockito.any(User.class));
	
	}
	//DO UPDATE TEST!!!!!!!!!!!
	@Test
	public void testingReadAll() {
		User micheal = new User(2L, "Micheal");
		User omkar = new User(3L, "Omkar");
		List<User> users = new ArrayList<>();
		users.add(micheal);
		users.add(omkar);

		when(this.userservice.readAll()).thenReturn(users);

		assertThat(users).isEqualTo(this.userservice.readAll());

		Mockito.verify(this.userservice, Mockito.times(1)).readAll();
	}
	
	@Test
	public void testingReadByUserId() {
		User micheal = new User(2L, "Micheal");

		when(this.userservice.readByUserId(2L)).thenReturn(micheal);

		Mockito.verify(this.userservice, Mockito.times(1)).readByUserId(2L);//MAYBE WORK ON THIS TEST
	}
	


	@Test
	public void testingDelete() {
		User micheal = new User(2L, "Micheal");
		when(this.userrepo.findById(2L)).thenReturn(Optional.of(micheal));
		
		this.userservice.deleteUser(2L);
		
		assertThat(true).isEqualTo(!(this.userrepo.existsById(2L)));
		
		Mockito.verify(this.userrepo, Mockito.times(1)).findById(2L);
		Mockito.verify(this.userrepo, Mockito.times(1)).deleteById(2L);
		Mockito.verify(this.userrepo, Mockito.times(1)).existsById(2L);

	}

}
