package com.Capstone.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity

@Table(name = "Workout")

public class Workout {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;

	@Column(name = "name", nullable = true)
	String name;

	public List<BodyPart> getBodyParts() {
		return bodyParts;
	}


	public void setBodyParts(List<BodyPart> bodyParts) {
		this.bodyParts = bodyParts;
	}

	@OneToMany
	@JoinColumn(name="workoutId", referencedColumnName = "id")
	List<BodyPart> bodyParts;
	
	public Workout() {
		super();
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}
	
}