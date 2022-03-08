package com.qa.ToDoList.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.ToDoList.domain.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	Optional<User> findByName(String name);

}
