package com.qa.ToDoList.rest;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.ToDoList.domain.Task;
import com.qa.ToDoList.domain.TaskUser;

@SpringBootTest
@AutoConfigureMockMvc
@Sql(scripts = {"classpath:test-schema.sql", "classpath:test-data.sql"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class TaskControllerIntegrationTest {
	
	@Autowired
	private MockMvc mock;
	
	@Autowired
	private ObjectMapper jsonifier;
	
	private Long id = 1L;
	
	@Test
	public void testingCreate() throws Exception{

		Task task2 = new Task(1L, "Workout", true);
		
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.POST, "http://localhost:8080/task").contentType(MediaType.APPLICATION_JSON).content(jsonifier.writeValueAsString(task2)).accept(MediaType.APPLICATION_JSON);
		
		ResultMatcher status = MockMvcResultMatchers.status().isCreated();
		ResultMatcher content = MockMvcResultMatchers.content().json(jsonifier.writeValueAsString(task2));
		
		this.mock.perform(mockRequest).andExpect(status).andExpect(content);
	}
	
	@Test
	public void testingReadAll() throws Exception{
		
		List<Task> tasks = new ArrayList<Task>();

		Task task = new Task(1L, "finish this project", false);
		tasks.add(task);
				
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.GET, "http://localhost:8080/task/all");
		
		ResultMatcher status = MockMvcResultMatchers.status().isOk();
		ResultMatcher content = MockMvcResultMatchers.content().json(jsonifier.writeValueAsString(tasks));
		
		this.mock.perform(mockRequest).andExpect(status).andExpect(content);
	}
	
	@Test
	public void testingReadById() throws Exception{
		
		Task task = new Task(1L, "finish this project", false);

		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.GET, "http://localhost:8080/task/" + id);
		
		ResultMatcher status = MockMvcResultMatchers.status().isOk();
		ResultMatcher content = MockMvcResultMatchers.content().json(jsonifier.writeValueAsString(task));
		
		this.mock.perform(mockRequest).andExpect(status).andExpect(content);
	}
	
	@Test
	public void testingUpdate() throws Exception{
		
		Task task = new Task(1L, "finish this project", false);
		
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.PUT, "http://localhost:8080/task/update/" + task.getId()).contentType(MediaType.APPLICATION_JSON).content(jsonifier.writeValueAsString(task)).accept(MediaType.APPLICATION_JSON);
		
		ResultMatcher status = MockMvcResultMatchers.status().isOk();
		ResultMatcher content = MockMvcResultMatchers.content().json(jsonifier.writeValueAsString(task));
		
		this.mock.perform(mockRequest).andExpect(status).andExpect(content);
	}
	
	@Test
	public void testingDelete() throws Exception{
		
		Task task = new Task(1L, "finish this project", false);
		
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.DELETE, "http://localhost:8080/task/delete/" + task.getId());
		
		ResultMatcher status = MockMvcResultMatchers.status().isNoContent();
		
		this.mock.perform(mockRequest).andExpect(status);
	}
	
	@Test
	public void testingAssign() throws Exception{
		
		Task task = new Task(1L, "finish this project", false);
		TaskUser user = new TaskUser(1L, "Omkar");
		
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.PUT, "http://localhost:8080/task/" + task.getId() + "/user/" + user.getId()).contentType(MediaType.APPLICATION_JSON).content(jsonifier.writeValueAsString(task)).accept(MediaType.APPLICATION_JSON);
		
		ResultMatcher status = MockMvcResultMatchers.status().isOk();
		ResultMatcher content = MockMvcResultMatchers.content().json(jsonifier.writeValueAsString(task));
		
		this.mock.perform(mockRequest).andExpect(status).andExpect(content);
	}

}
