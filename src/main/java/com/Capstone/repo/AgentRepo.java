package com.Capstone.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Capstone.entity.Agent;
@Repository
public interface AgentRepo extends JpaRepository<Agent, Integer>{
	
	@Query(value = "select * from agent where email = ?1 && password=?2", nativeQuery=true)
	public Agent agentSignIn(String email, String password);
}