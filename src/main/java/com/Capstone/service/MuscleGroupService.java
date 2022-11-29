package com.Capstone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Capstone.entity.BodyPart;
import com.Capstone.entity.MuscleGroup;
import com.Capstone.entity.Workout;
import com.Capstone.repo.MuscleGroupRepo;

@Service
public class MuscleGroupService {

	@Autowired
	MuscleGroupRepo muscleGroupRepo;
	
	@Autowired
	BodyPartService bodyPartService;

	public MuscleGroup save(MuscleGroup muscleGroup, Integer bodyPartId) {

		BodyPart bodyPart = bodyPartService.getById(bodyPartId);

		bodyPart.getMuscleGroup().add(muscleGroup);

		muscleGroupRepo.save(muscleGroup);
		
		bodyPartService.defaultSave(bodyPart);
		
		return (muscleGroup);

		
	}
	
	public List<MuscleGroup> getByMuscleGroup(String muscle_group_name) {
		
		 return muscleGroupRepo.getAllByMuscleGroup(muscle_group_name);
		
		
	}
	
	public MuscleGroup getMuscleGroupById(Integer id) {
		
		 return muscleGroupRepo.findById(id).get();
		
		
	}
			
}