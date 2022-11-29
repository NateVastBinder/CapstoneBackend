package com.Capstone.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Capstone.entity.MuscleGroup;
import com.Capstone.entity.User;
import com.Capstone.entity.Workout;

@Repository
public interface MuscleGroupRepo extends JpaRepository<MuscleGroup, Integer>{
	
	@Query(value = "select * from muscle_group where muscle_group_name = ?1 ", nativeQuery = true)
	List<MuscleGroup>getAllByMuscleGroup(String muscle_group_name);

	
}