package com.qa.ToDoList.repo;

import org.springframework.data.jpa.repository.JpaRepository;


import com.qa.ToDoList.domain.TaskUser;

public interface UserRepository extends JpaRepository<TaskUser, Long>{

}
