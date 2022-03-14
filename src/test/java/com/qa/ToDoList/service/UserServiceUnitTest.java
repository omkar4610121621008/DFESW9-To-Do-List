package com.qa.ToDoList.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.ToDoList.domain.TaskUser;
import com.qa.ToDoList.repo.UserRepository;

//ANNOTATIONS????
@SpringBootTest
public class UserServiceUnitTest {
	
	@MockBean
	private UserService userservice;
	
	@MockBean
	private UserRepository userrepo;

	
	@Test
	public void testingCreateUser() {
		TaskUser user = new TaskUser(1L, "John");
		
		when(userrepo.save(Mockito.any(TaskUser.class))).thenReturn(user);
		
		TaskUser expect = this.userservice.createUser(user);
		
		assertThat(expect).isEqualTo(this.userservice.createUser(user));
		
	
	}
	//DO UPDATE TEST!!!!!!!!!!!
	@Test
	public void testingReadAll() {
		TaskUser micheal = new TaskUser(2L, "Micheal");
		TaskUser omkar = new TaskUser(3L, "Omkar");
		List<TaskUser> users = new ArrayList<>();
		users.add(micheal);
		users.add(omkar);

		when(this.userservice.readAll()).thenReturn(users);

		assertThat(users).isEqualTo(this.userservice.readAll());

		verify(this.userservice, Mockito.times(1)).readAll();
	}
	
	@Test
	public void testingReadByUserId() {
		TaskUser micheal = new TaskUser(2L, "Micheal");

		when(this.userservice.readByUserId(micheal.getId())).thenReturn(micheal);

		//Mockito.verify(this.userservice, Mockito.times(1)).readByUserId(micheal.getId());//MAYBE WORK ON THIS TEST
	}
	


	@Test
	public void testingDelete() {
		TaskUser micheal = new TaskUser(2L, "Micheal");
		when(this.userrepo.findById(2L)).thenReturn(Optional.of(micheal));
		
		this.userservice.deleteUser(2L);
		
		assertThat(true).isEqualTo(!(this.userrepo.existsById(2L)));
		
		//Mockito.verify(this.userrepo, Mockito.times(1)).findById(2L);
		//Mockito.verify(this.userrepo, Mockito.times(1)).deleteById(2L);
		Mockito.verify(this.userrepo, Mockito.times(1)).existsById(2L);

	}

}
