package com.Capstone.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table(name = "agent")

public class Agent {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;

	
	@Column(name = "email", nullable = false)
	String email;
	@Column(name = "password", nullable = false)
	String password;
	
	public Agent() {
		super();
	}
	
	public Agent(Integer id, String fullName, String email, String password){
	this.id = id;
	this.email = email;
	this.password = password;
	
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getId() {
		return id;
		
	}
	@Override
	public String toString() {
		return "User[ id=" + id + "email" + email + ", password=" + password; 
	}
	
}