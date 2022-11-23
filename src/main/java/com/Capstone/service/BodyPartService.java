package com.Capstone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Capstone.entity.BodyPart;
import com.Capstone.entity.Workout;
import com.Capstone.repo.BodyPartRepo;



@Service
public class BodyPartService {
	
	@Autowired
	BodyPartRepo bodyPartRepo;
	
	@Autowired
	WorkoutService workoutService;
	

	

	public BodyPart save(BodyPart bodyPart, Integer workoutId) {

		
		Workout workout = workoutService.getById(workoutId);
		
		workout.getBodyParts().add(bodyPart);
		
		bodyPartRepo.save(bodyPart);
		
		
		workoutService.save(workout);
		
		return (bodyPart);
	}
	
	public BodyPart getById(Integer id) {

		
		return bodyPartRepo.findById(id).get();

	}
	

	public BodyPart defaultSave(BodyPart bodyPart) {

		return bodyPartRepo.save(bodyPart);
	}
	
}