package com.qa.ToDoList.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.ToDoList.domain.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{
	
	public List<Task> findByUserId(Long id);

}
