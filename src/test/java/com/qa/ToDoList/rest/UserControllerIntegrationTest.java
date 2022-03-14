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
public class UserControllerIntegrationTest {
	
	@Autowired
	private MockMvc mock;
	
	//@Autowired
	//private ModelMapper mapper;
	
	@Autowired
	private ObjectMapper jsonifier;
	
	@Test
	public void testingCreate() throws Exception{
		//User user = new User(1L, "Omkar");
		TaskUser john = new TaskUser(2L, "John");
		
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.POST, "http://localhost:8080/user").contentType(MediaType.APPLICATION_JSON).content(jsonifier.writeValueAsString(john)).accept(MediaType.APPLICATION_JSON);
		
		ResultMatcher status = MockMvcResultMatchers.status().isCreated();
		ResultMatcher content = MockMvcResultMatchers.content().json(jsonifier.writeValueAsString(john));
		
		this.mock.perform(mockRequest).andExpect(status).andExpect(content);
	}
	
	@Test
	public void testingReadAll() throws Exception{
		
		List<TaskUser> users = new ArrayList<TaskUser>();
		TaskUser user = new TaskUser(1L, "Omkar");
		
		users.add(user);
				
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.GET, "http://localhost:8080/user/all");
		
		ResultMatcher status = MockMvcResultMatchers.status().isOk();
		ResultMatcher content = MockMvcResultMatchers.content().json(jsonifier.writeValueAsString(users));
		
		this.mock.perform(mockRequest).andExpect(status).andExpect(content);
	}
	
	@Test
	public void testingReadById() throws Exception{
		TaskUser user = new TaskUser(1L, "Omkar");

		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.GET, "http://localhost:8080/user/" + user.getId());
		
		ResultMatcher status = MockMvcResultMatchers.status().isOk();
		ResultMatcher content = MockMvcResultMatchers.content().json(jsonifier.writeValueAsString(user));
		
		this.mock.perform(mockRequest).andExpect(status).andExpect(content);
	}
	
	@Test
	public void testingUpdate() throws Exception{
		
		TaskUser user = new TaskUser(1L, "Omkar");
		
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.PUT, "http://localhost:8080/user/update/" + user.getId()).contentType(MediaType.APPLICATION_JSON).content(jsonifier.writeValueAsString(user)).accept(MediaType.APPLICATION_JSON);
		
		ResultMatcher status = MockMvcResultMatchers.status().isOk();
		ResultMatcher content = MockMvcResultMatchers.content().json(jsonifier.writeValueAsString(user));
		
		this.mock.perform(mockRequest).andExpect(status).andExpect(content);
	}
	
	@Test
	public void testingDelete() throws Exception{
		
		TaskUser user = new TaskUser(1L, "Omkar");
		
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.DELETE, "http://localhost:8080/user/delete/" + user.getId());
		
		ResultMatcher status = MockMvcResultMatchers.status().isNoContent();
		
		this.mock.perform(mockRequest).andExpect(status);
	}

}
