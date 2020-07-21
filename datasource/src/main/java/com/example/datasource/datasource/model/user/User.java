package com.example.datasource.datasource.model.user;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
//lombock - reduces no of lines code
public class User {

	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;

	public User() {

	}

	public User(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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
		return "User [id=" + id + ", name=" + name + "]";
	}

}
