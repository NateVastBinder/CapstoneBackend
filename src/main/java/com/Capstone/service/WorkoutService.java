package com.Capstone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Capstone.entity.Workout;
import com.Capstone.repo.WorkoutRepo;



@Service
public class WorkoutService {
	
	@Autowired
	WorkoutRepo workoutRepo;
	

	

	public Workout save(Workout workout) {

		return workoutRepo.save(workout);
	}
	
	public List<Workout> getAll() {

		
		//find all of the vehicles that dont have a user id on them
		
		return workoutRepo.getAll();

	}
	
	public Workout getById(Integer id) {

		
		return workoutRepo.findById(id).get();

	}
}