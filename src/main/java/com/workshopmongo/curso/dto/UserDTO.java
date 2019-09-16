package com.workshopmongo.curso.dto;

import org.bson.types.ObjectId;

import com.workshopmongo.curso.domain.User;

public class UserDTO {
	
	private ObjectId id;
	
	private String name;
	
	private String email;
	
	public UserDTO() {
		
	}
	
	public UserDTO(User obj) {
		this.id = obj.getId();
		this.name = obj.getName();
		this.email = obj.getEmail();
		
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}