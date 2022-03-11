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

import com.qa.ToDoList.domain.Task;
import com.qa.ToDoList.repo.TaskRepository;
//ANNOTATIONS????
public class TaskServiceUnitTest {
	
	@InjectMocks
	private TaskService service;//ADD A UPDATE TEST AS WELL!!!
	
	@Mock
	private TaskRepository repo;

	
	@Test
	public void testingCreateTask() {
		Task todo = new Task(1L, "Gotta finish this project", true);
		
		when(repo.save(Mockito.any(Task.class))).thenReturn(todo);
		
		Task task = this.service.createTask(todo);
		
		assertThat(task).isEqualTo(todo);
		
		Mockito.verify(this.repo, Mockito.times(1)).save(Mockito.any(Task.class));
	
	}
	
	@Test
	public void testingReadAllTasks() {
		Task todo = new Task(1L, "Gotta finish this project", true);
		Task todo2 = new Task(108L, "Still gotta finish this project", false);
		List<Task> tasks = new ArrayList<>();
		tasks.add(todo);
		tasks.add(todo2);

		when(this.service.readAllTasks()).thenReturn(tasks);

		assertThat(tasks).isEqualTo(this.service.readAllTasks());

		Mockito.verify(this.service, Mockito.times(1)).readAllTasks();
	}
	
	@Test
	public void testingReadByTaskId() {
		Task todo = new Task(1L, "Gotta finish this project", false);

		when(this.service.readByTaskId(1L)).thenReturn(todo);

		Mockito.verify(this.service, Mockito.times(1)).readByTaskId(1L);
	}
	


	@Test
	public void testingDeleteTask() {
		Task todo = new Task(1L, "Gotta finish this project", true);
		
		when(this.repo.findById(1L)).thenReturn(Optional.of(todo));
		
		this.service.deleteTask(1L);
		
		assertThat(true).isEqualTo(!(this.repo.existsById(1L)));
		
		Mockito.verify(this.repo, Mockito.times(1)).findById(1L);
		Mockito.verify(this.repo, Mockito.times(1)).deleteById(1L);
		Mockito.verify(this.repo, Mockito.times(1)).existsById(1L);

	}

}
