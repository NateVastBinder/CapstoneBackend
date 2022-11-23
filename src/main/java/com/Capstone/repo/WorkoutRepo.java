package com.Capstone.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Capstone.entity.User;
import com.Capstone.entity.Workout;

@Repository
public interface WorkoutRepo extends JpaRepository<Workout, Integer>{

	@Query(value = "select * from vehicles where user_id IS null", nativeQuery = true)
	List<Workout>getAll();
	
}