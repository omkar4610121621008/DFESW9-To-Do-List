package com.qa.ToDoList.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;


public class UserDomainUnitTest {
	
	
	@Test
	public void userConstructorEmptyTest() {
		TaskUser user = new TaskUser();
		assertNull(user.getId());
		assertNull(user.getName());
		assertNull(user.getTasks());
		
		assertThat(user).isInstanceOf(TaskUser.class);
	}
	
	@Test
	public void userConstructorWithoutTasks() {
		TaskUser user = new TaskUser(108L, "Omkar");
		assertNotNull(user.getId());
		assertNotNull(user.getName());
		assertNull(user.getTasks());
		
		assertThat(user).isInstanceOf(TaskUser.class);
		assertThat(user.getId()).isEqualTo(108L);
		assertThat(user.getName()).isEqualTo("Omkar");
	}
	
	@Test
	public void userConstructorWithNameOnly() {
		TaskUser user = new TaskUser("Omkar");
		assertNull(user.getId());
		assertNotNull(user.getName());
		assertNull(user.getTasks());
		
		assertThat(user).isInstanceOf(TaskUser.class);
		assertThat(user.getName()).isEqualTo("Omkar");
	}
	
	@Test
	public void TestingUserSetters() {
		TaskUser user = new TaskUser(10L, "Micheal");
		user.setId(11L);
		assertThat(user.getId()).isEqualTo(11L);
		user.setName("Omkar");
		assertThat(user.getName()).isEqualTo("Omkar");
		//add task as well
	}
	
	

}
