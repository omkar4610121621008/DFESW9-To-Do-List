package com.qa.ToDoList.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.ToDoList.domain.User;
import com.qa.ToDoList.service.UserService;


@RestController
public class UserController {

  private UserService service;//DO I NEED THIS???     ////\\\\\
  
  @Autowired
	public UserController(UserService service) {
		this.service = service;
	}

  @GetMapping("/user/all")
  public ResponseEntity<List<User>> readAllUsers() {
    return new ResponseEntity<>(this.service.readAll(), HttpStatus.OK);
  }

  @GetMapping("/user/{id}")
  public ResponseEntity<User> getUserById(@PathVariable long id) {
    return new ResponseEntity<>(this.service.readByUserId(id), HttpStatus.OK);
  }

  @PostMapping("/user")
  public ResponseEntity<User> createUser(@RequestBody User body) {
    return new ResponseEntity<>(this.service.createUser(body), HttpStatus.CREATED);
  }

  @PutMapping("/user-update/{id}")
  public ResponseEntity<User> updateUser(@PathVariable long id, @RequestBody User body) {
	  return new ResponseEntity<>(this.service.updateUser(id, body), HttpStatus.OK);
  }

  @DeleteMapping("/delete-user/{id}")
  public ResponseEntity<HttpStatus> deleteUser(@PathVariable long id) {
    return new ResponseEntity<>(this.service.deleteUser(id) ? HttpStatus.NO_CONTENT: HttpStatus.INTERNAL_SERVER_ERROR);
  }//referenced those httpstatus from another project due to being stuck
  
}


