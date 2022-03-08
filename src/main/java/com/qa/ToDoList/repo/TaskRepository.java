package com.qa.ToDoList.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.ToDoList.domain.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{

}
