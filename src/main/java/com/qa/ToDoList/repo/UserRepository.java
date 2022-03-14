package com.qa.ToDoList.repo;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.qa.ToDoList.domain.TaskUser;

public interface UserRepository extends JpaRepository<TaskUser, Long>{
	
	Optional<TaskUser> findByName(String name);
	
	//@Query("select user.id, name, completed, description from user join task on user.id = user_fk")
	//public List<User> findAllUsersWithTasks();

}
