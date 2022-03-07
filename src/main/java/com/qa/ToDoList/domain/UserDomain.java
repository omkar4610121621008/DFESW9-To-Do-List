package com.qa.ToDoList.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class UserDomain {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@OneToMany(targetEntity = TaskDomain.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_fk", referencedColumnName = "id")
	private List<TaskDomain> tasks;
	
	

	public UserDomain() {
		super();
	}
	

	public UserDomain(Long id, String name, List<TaskDomain> tasks) {
		super();
		this.id = id;
		this.name = name;
		this.tasks = tasks;
	}
	

	public UserDomain(String name, List<TaskDomain> tasks) {
		super();
		this.name = name;
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

	public List<TaskDomain> getTasks() {
		return tasks;
	}

	public void setTasks(List<TaskDomain> tasks) {
		this.tasks = tasks;
	}


	@Override
	public String toString() {
		return "UserDomain [id=" + id + ", name=" + name + ", tasks=" + tasks + "]";
	}
	
	
	
	
	
}
