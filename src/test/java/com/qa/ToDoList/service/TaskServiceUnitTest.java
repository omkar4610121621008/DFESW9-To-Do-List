package com.qa.ToDoList.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.ToDoList.domain.Task;
import com.qa.ToDoList.domain.TaskUser;
import com.qa.ToDoList.repo.TaskRepository;

@SpringBootTest
public class TaskServiceUnitTest {
	
	@MockBean
	private TaskService service;
	
	@MockBean
	private TaskRepository repo;

	
	@Test
	public void testingCreateTask() {
		Task todo = new Task(1L, "Gotta finish this project", true);
		
		when(repo.save(Mockito.any(Task.class))).thenReturn(todo);
		
		Task task = this.service.createTask(todo);
		
		assertThat(task).isEqualTo(this.service.createTask(todo));
	
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
		
		Task task = this.service.readByTaskId(todo.getId());
		
		assertThat(task).isEqualTo(todo);

		Mockito.verify(this.service, Mockito.times(1)).readByTaskId(1L);
	}
	


	@Test
	public void testingDeleteTask() {
		Task todo = new Task(1L, "Gotta finish this project", true);
		
		when(this.repo.findById(1L)).thenReturn(Optional.of(todo));
		
		this.service.deleteTask(1L);
		
		assertThat(true).isEqualTo(!(this.repo.existsById(1L)));
		
		Mockito.verify(this.repo, Mockito.times(1)).existsById(1L);

	}
	
	@Test
	public void testingUpdate() {
		Task todo = new Task(1L, "Gotta finish this project", true);
		Task todo2 = new Task(2L, "Gotta finish this project", false);
		Optional<Task> optional = Optional.of(todo);
		Task todo3 = new Task(1L, todo2.getDescription(), todo2.getCompleted());
		
		when(this.repo.findById(todo.getId())).thenReturn(optional);
		when(this.repo.save(Mockito.any(Task.class))).thenReturn(todo2);
		
		Task expect = this.service.updateTask(todo.getId(), todo2);
		
		assertThat(this.service.createTask(todo3)).isEqualTo(expect);
		
		
	}
	
	@Test
	public void testAssignTask() {
		Task todo = new Task(1L, "Gotta finish this project", true);
		Optional<Task> optional = Optional.of(todo);
		TaskUser user = new TaskUser(1L, "Omkar");
		Task todo3 = new Task(1L, todo.getDescription(), todo.getCompleted());
		todo3.setUser(user);
		when(this.repo.findById(todo.getId())).thenReturn(optional);
		
		Task expect = this.service.assignTask(1L, 1L);
		
		assertThat(this.service.createTask(todo3)).isEqualTo(expect);
		
	}

}
