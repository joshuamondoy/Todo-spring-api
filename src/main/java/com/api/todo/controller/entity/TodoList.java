package com.api.todo.controller.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="todo_list")
public class TodoList {
	@Id
	@GeneratedValue
	private Long id;
	@Column(name="username")
	private String username;
	@Column(name="description")
	private String description;
	@Column(name="is_done")
	private boolean isDone;
	@Column(name="target_date")
	private Date targetDate;

	public TodoList(Long id, String username, String description, boolean isDone, Date targetDate) {
		this.id = id;
		this.username = username;
		this.description = description;
		this.isDone = isDone;
		this.targetDate = targetDate;
	}
	protected TodoList() {
		// no args
	}

	@Override
	public String toString() {
		return "todoList [id=" + id + ", username=" + username + ", description=" + description + ", isDone=" + isDone
				+ ", date=" + targetDate + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isisDone() {
		return isDone;
	}

	public void setisDone(boolean isDone) {
		this.isDone = isDone;
	}

	public Date getDate() {
		return targetDate;
	}

	public void setDate(Date date) {
		this.targetDate = date;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
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
		TodoList other = (TodoList) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	

}
