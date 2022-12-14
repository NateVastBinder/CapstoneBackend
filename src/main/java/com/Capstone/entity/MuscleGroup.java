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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity

@Table(name = "MuscleGroup")

public class MuscleGroup {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;

	@Column(name = "exercise_name")
	String exerciseName;
	@Column(name = "muscle_group_name")
	String muscleGroupName;
	@Column(name = "reps")
	String reps = "8-12";
	
//	@ManyToMany(
//			mappedBy="muscle_group"
//	)
//	@JsonIgnore
//	List<User> workouts;
	

	
	public MuscleGroup() {
		super();
	}

	public String getExerciseName() {
		return exerciseName;
	}

	public void setExerciseName(String exerciseName) {
		this.exerciseName = exerciseName;
	}

	public String getMuscleGroupName() {
		return muscleGroupName;
	}

	public void setMuscleGroupName(String muscleGroupName) {
		this.muscleGroupName = muscleGroupName;
	}

	
	public String getReps() {
		return reps;
	}

	public void setReps(String reps) {
		this.reps = reps;
	}

	public Integer getId() {
		return id;
	}

}