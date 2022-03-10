package com.qa.ToDoList.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

public class TaskDomainUnitTest {
	
	@Test
	public void taskConstructorEmptyTest() {
		Task task = new Task();
		assertNull(task.getId());
		assertNull(task.getDescription());
		assertNotNull(task.getCompleted());
		assertNull(task.getUser());
		
		assertThat(task).isInstanceOf(Task.class);
		assertThat(task.getCompleted()).isEqualTo(false);
	}
	
	@Test
	public void taskConstructorWithDescriptionOnly() {
		Task task = new Task("Finish To Do List Project");
		assertNull(task.getId());
		assertNotNull(task.getDescription());
		assertNotNull(task.getCompleted());
		assertNull(task.getUser());
		
		assertThat(task).isInstanceOf(Task.class);
		assertThat(task.getDescription()).isEqualTo("Finish To Do List Project");
		assertThat(task.getCompleted()).isEqualTo(false);
	}
	
	@Test
	public void taskConstructor3() {
		User user = new User("Omkar");
		Task task = new Task("Finish To Do List Project", user);
		assertNull(task.getId());
		assertNotNull(task.getDescription());
		assertNotNull(task.getCompleted());
		assertNotNull(task.getUser());
		
		assertThat(task).isInstanceOf(Task.class);
		assertThat(task.getDescription()).isEqualTo("Finish To Do List Project");
		assertThat(task.getUser()).isEqualTo(user);
		assertThat(task.getCompleted()).isEqualTo(false);
	}
	
	
	@Test
	public void taskConstructor4() {
		Task task = new Task(2L,"Finish To Do List Project", true);
		assertNotNull(task.getId());
		assertNotNull(task.getDescription());
		assertNotNull(task.getCompleted());
		assertNull(task.getUser());
		
		assertThat(task).isInstanceOf(Task.class);
		assertThat(task.getId()).isEqualTo(2L);
		assertThat(task.getDescription()).isEqualTo("Finish To Do List Project");
		assertThat(task.getCompleted()).isEqualTo(true);
	}
	
	@Test
	public void taskConstructor5() {
		User user = new User("Omkar");
		Task task = new Task(3L,"Finish To Do List Project", false, user);
		assertNotNull(task.getId());
		assertNotNull(task.getDescription());
		assertNotNull(task.getCompleted());
		assertNotNull(task.getUser());
		
		assertThat(task).isInstanceOf(Task.class);
		assertThat(task.getId()).isEqualTo(3L);
		assertThat(task.getDescription()).isEqualTo("Finish To Do List Project");
		assertThat(task.getCompleted()).isEqualTo(false);
		assertThat(task.getUser()).isEqualTo(user);
	}
	
	@Test
	public void TestingTaskSetters() {
		Task task = new Task(3L,"Finish To Do List Project", false);
		task.setId(10L);
		assertThat(task.getId()).isEqualTo(10L);
		task.setDescription("Play Piano");
		assertThat(task.getDescription()).isEqualTo("Play Piano");
		task.setCompleted(true);
		assertThat(task.getCompleted()).isEqualTo(true);
		//add user as well
	}

}
