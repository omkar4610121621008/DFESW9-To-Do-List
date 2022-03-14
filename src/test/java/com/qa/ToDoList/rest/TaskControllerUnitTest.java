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

import com.qa.ToDoList.domain.Task;
import com.qa.ToDoList.domain.TaskUser;
import com.qa.ToDoList.service.TaskService;
@SpringBootTest
public class TaskControllerUnitTest {
	
	@MockBean
	private TaskService service;
	
	@Autowired
	private TaskController controller;
	
	@Test
	public void createTaskTest() {
		Task task = new Task(1L, "Still gotta finish this project", false);
		Mockito.when(this.service.createTask(task)).thenReturn(task);
		
		ResponseEntity<Task> task2 = this.controller.createTask(task);
		assertThat(task2).isEqualTo(new ResponseEntity<Task>(task, HttpStatus.CREATED));
		
	}
	
	@Test
	public void readAllTasksTest() {
		Task task = new Task(1L, "Still gotta finish this project", false);
		Task task2 = new Task(2L, "Exercise", true);
		List<Task> tasks = new ArrayList<Task>();
		tasks.add(task);
		tasks.add(task2);

		Mockito.when(this.service.readAllTasks()).thenReturn(tasks);

		ResponseEntity<List<Task>> same = new ResponseEntity<List<Task>>(tasks, HttpStatus.OK);

		assertThat(same).isEqualTo(controller.readAllTasks());
		
		Mockito.verify(this.service, Mockito.times(1)).readAllTasks();
		
	}
	
	@Test
	public void readByIdTest() {
		Task task = new Task(1L, "Still gotta finish this project", false);
		
		Mockito.when(this.service.readByTaskId(task.getId())).thenReturn(task);
		
		ResponseEntity<Task> another = new ResponseEntity<Task>(task, HttpStatus.OK);
		
		assertThat(another).isEqualTo(controller.getTaskById(task.getId()));
		
		Mockito.verify(this.service, Mockito.times(1)).readByTaskId(task.getId());
	}
	
	@Test
	public void deleteTaskTest() {
		
		Task task = new Task(1L, "Still gotta finish this project", false);
		
		Mockito.when(this.service.deleteTask(task.getId())).thenReturn(true);
		
        ResponseEntity<Boolean> bool = this.controller.deleteTaskById(task.getId());
		
		assertThat(bool).isEqualTo(new ResponseEntity<Boolean>(HttpStatus.NO_CONTENT));
		
		Mockito.verify(this.service, Mockito.times(1)).deleteTask(task.getId());
	}
	
	@Test
	public void updateTaskTest() {
		
		Task task = new Task(1L, "Still gotta finish this project", false);
		Task task2 = new Task(2L, "Exercise", true);
		
		Mockito.when(this.service.updateTask(task.getId(), task2)).thenReturn(task2);
		
		ResponseEntity<Task> anotherone = new ResponseEntity<Task>(task2, HttpStatus.OK);//MAYBE WORK ON THIS???
		
		assertThat(anotherone).isEqualTo(controller.updateTaskById(task.getId(), task2));
		
		Mockito.verify(this.service, Mockito.times(1)).updateTask(task.getId(), task2);
		
	}
	
	@Test
	public void assignTaskToUserTest() {
		
		Task task = new Task(1L, "Still gotta finish this project", false);
		TaskUser user = new TaskUser(100L, "Omkar");
		
		//Mockito.when(this.service.assignTask(task.getId(), user.getId()).thenReturn(task));
		
		ResponseEntity<Task> anotherone = this.controller.assignUserToTask(task.getId(), user.getId());
		
		assertThat(anotherone).isEqualTo(new ResponseEntity<Task>(HttpStatus.OK));
	}
	
	

}
