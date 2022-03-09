package com.qa.ToDoList.domain;



import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY )
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<Task> tasks;
	

	public User() {
		super();
	}
	

	public User(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	

	public User(String name) {
		super();
		this.name = name;
	}


	public User(Long id, String name, List<Task> tasks) {
		super();
		this.id = id;
		this.name = name;
		this.tasks = tasks;
	}


	public List<Task> getTasks() {
		return tasks;
	}


	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	//public List<Task> getTasks() {
	//	return tasks;
	//}


	//public void setTasks(List<Task> tasks) {
	//	this.tasks = tasks;
	//}


	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + "]";
	}
	
	
	
	
	
}
