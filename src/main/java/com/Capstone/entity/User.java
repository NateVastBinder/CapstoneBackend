 package com.Capstone.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity

@Table(name = "user")

public class User {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;

	@Column(name = "fullname", nullable = false)
	String fullName;
	@Column(name = "email", nullable = false)
	String email;
	@Column(name = "password", nullable = false)
	String password;
	
	@ManyToMany
	@JoinTable(
			name="user_workouts",
			joinColumns=@JoinColumn(name="user_id"),
			inverseJoinColumns=@JoinColumn(name="muscle_group_id")
	)
	List<MuscleGroup> workouts;
	
	public User() {
		super();
	}

	public User(Integer id, String fullName, String email, String password) {
		this.id = id;
		this.fullName = fullName;
		this.email = email;
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
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
	
	
	public List<MuscleGroup> getWorkouts() {
		return workouts;
	}

	public void setWorkouts(List<MuscleGroup> workouts) {
		this.workouts = workouts;
	}

	@Override
	public String toString() {
		return "User[ id=" + id + ",FullName = " + fullName + ", email" + email + ", password=" + password; 
	}

}