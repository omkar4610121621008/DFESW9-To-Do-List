package com.qa.ToDoList.rest;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.ToDoList.domain.Task;
import com.qa.ToDoList.domain.User;

@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class TaskControllerIntegrationTest {
	
	@Autowired
	private MockMvc mock;
	
	//@Autowired
	//private ModelMapper mapper;
	
	@Autowired
	private ObjectMapper jsonifier;
	
	@Test
	public void testingCreate() throws Exception{
		Task task = new Task(1L, "Still gotta finish this project", false);
		Task task2 = new Task(2L, "Workout", true);
		
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.POST, "http://localhost:8080/task").contentType(MediaType.APPLICATION_JSON).content(jsonifier.writeValueAsString(task)).accept(MediaType.APPLICATION_JSON);
		
		ResultMatcher status = MockMvcResultMatchers.status().isCreated();
		ResultMatcher content = MockMvcResultMatchers.content().json(jsonifier.writeValueAsString(task2));
		
		this.mock.perform(mockRequest).andExpect(status).andExpect(content);
	}
	
	@Test
	public void testingReadAll() throws Exception{
		
		List<Task> tasks = new ArrayList<Task>();
		Task task = new Task(1L, "Still gotta finish this project", false);
		Task task2 = new Task(2L, "Workout", true);
		tasks.add(task);
		tasks.add(task2);
				
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.GET, "http://localhost:8080/task/all");
		
		ResultMatcher status = MockMvcResultMatchers.status().isOk();
		ResultMatcher content = MockMvcResultMatchers.content().json(jsonifier.writeValueAsString(tasks));
		
		this.mock.perform(mockRequest).andExpect(status).andExpect(content);
	}
	
	@Test
	public void testingReadById() throws Exception{
		
		Task task = new Task(1L, "Still gotta finish this project", false);

		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.GET, "http://localhost:8080/task/" + task.getId());
		
		ResultMatcher status = MockMvcResultMatchers.status().isOk();
		ResultMatcher content = MockMvcResultMatchers.content().json(jsonifier.writeValueAsString(task));
		
		this.mock.perform(mockRequest).andExpect(status).andExpect(content);
	}
	
	@Test
	public void testingUpdate() throws Exception{
		
		Task task = new Task(1L, "Still gotta finish this project", false);
		
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.PUT, "http://localhost:8080/task/update/" + task.getId()).contentType(MediaType.APPLICATION_JSON).content(jsonifier.writeValueAsString(task)).accept(MediaType.APPLICATION_JSON);
		
		ResultMatcher status = MockMvcResultMatchers.status().isOk();
		ResultMatcher content = MockMvcResultMatchers.content().json(jsonifier.writeValueAsString(task));
		
		this.mock.perform(mockRequest).andExpect(status).andExpect(content);
	}
	
	@Test
	public void testingDelete() throws Exception{
		
		Task task = new Task(1L, "Still gotta finish this project", false);
		
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.DELETE, "http://localhost:8080/task/delete/" + task.getId());
		
		ResultMatcher status = MockMvcResultMatchers.status().isNoContent();
		
		this.mock.perform(mockRequest).andExpect(status);
	}
	
	@Test
	public void testingAssign() throws Exception{
		
		Task task = new Task(1L, "Still gotta finish this project", false);
		User user = new User(1L, "Omkar");
		
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.PUT, "http://localhost:8080/task/" + task.getId() + "/user/" + user.getId()).contentType(MediaType.APPLICATION_JSON).content(jsonifier.writeValueAsString(task)).accept(MediaType.APPLICATION_JSON);
		
		ResultMatcher status = MockMvcResultMatchers.status().isOk();
		ResultMatcher content = MockMvcResultMatchers.content().json(jsonifier.writeValueAsString(task));
		
		this.mock.perform(mockRequest).andExpect(status).andExpect(content);
	}

}
