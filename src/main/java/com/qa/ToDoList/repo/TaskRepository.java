package com.qa.ToDoList.repo;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.qa.ToDoList.domain.Task;
import com.qa.ToDoList.domain.User;

public interface TaskRepository extends JpaRepository<Task, Long>{
	
	public List<Task> findByUserId(Long user_id, Pageable pageable);
	

}
