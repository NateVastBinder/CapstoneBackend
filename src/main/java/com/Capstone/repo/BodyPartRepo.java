package com.Capstone.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Capstone.entity.BodyPart;
import com.Capstone.entity.User;

@Repository
public interface BodyPartRepo extends JpaRepository<BodyPart, Integer>{

	
}