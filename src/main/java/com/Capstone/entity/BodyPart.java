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

@Table(name = "BodyPart")

public class BodyPart {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;

	@Column(name = "name", nullable = false)
	String name;

	
	@OneToMany
	@JoinColumn(name="bodyPartId", referencedColumnName = "id")
	List<MuscleGroup> muscleGroup;
	
	public BodyPart() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<MuscleGroup> getMuscleGroup() {
		return muscleGroup;
	}

	public void setMuscleGroup(List<MuscleGroup> muscleGroup) {
		this.muscleGroup = muscleGroup;
	}

	public Integer getId() {
		return id;
	}
	
	
	
}