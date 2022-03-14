package com.qa.ToDoList.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name = "task")
public class Task {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String description;
	
	@Column(name = "completed", nullable = false)
	private Boolean completed = false;//ADD DEFAULT VALUE AND ITS STILL REQUIRED FOR SOME REASON
	
	@ManyToOne(targetEntity = TaskUser.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "user_fk", referencedColumnName = "id")
	@JsonBackReference
	private TaskUser user;

	public Task() {
		super();
	}

	
	public Task(String description) {
		super();
		this.description = description;
	}
	

	public Task(String description, TaskUser user) {
		super();
		this.description = description;
		this.user = user;
	}
	
	
	public Task(Long id, String description, Boolean completed) {
		super();
		this.id = id;
		this.description = description;
		this.completed = completed;
	}


	public Task(Long id, String description, Boolean completed, TaskUser user) {
		super();
		this.id = id;
		this.description = description;
		this.completed = completed;
		this.user = user;
	}


	public TaskUser getUser() {
		return user;
	}

	public void setUser(TaskUser user) {
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getCompleted() {
		return completed;
	}

	public void setCompleted(Boolean completed) {
		this.completed = completed;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", description=" + description + ", completed=" + completed + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((completed == null) ? 0 : completed.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Task other = (Task) obj;
		if (completed == null) {
			if (other.completed != null)
				return false;
		} else if (!completed.equals(other.completed))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}


}
