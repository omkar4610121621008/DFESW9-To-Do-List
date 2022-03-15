package com.qa.ToDoList.domain;



import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name = "taskUser")
public class TaskUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true )
	@JsonManagedReference
	private List<Task> tasks;
	

	public TaskUser() {
		super();
	}
	

	public TaskUser(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	

	public TaskUser(String name) {
		super();
		this.name = name;
	}


	public TaskUser(Long id, String name, List<Task> tasks) {
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


	@Override
	public String toString() {
		return "TaskUser [id=" + id + ", name=" + name + ", tasks=" + tasks + "]";
	}


	
	
	
}
