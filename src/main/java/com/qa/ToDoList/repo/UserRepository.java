package com.qa.ToDoList.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.ToDoList.domain.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
