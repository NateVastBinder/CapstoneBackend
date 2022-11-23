package com.Capstone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Capstone.entity.Agent;
import com.Capstone.entity.User;
import com.Capstone.repo.AgentRepo;



@Service
public class AgentService {
	
	@Autowired
	AgentRepo agentRepo;
	

	public List<Agent> getAll() {

		return agentRepo.findAll();

	}

	public Agent save(Agent agent) {

		return agentRepo.save(agent);
	}
	
	public Agent agentSignIn(Agent agent) throws Exception {
		  
		Agent foundAgent= agentRepo.agentSignIn(agent.getEmail(), agent.getPassword());
		  
		if (foundAgent == null) {
			throw new Exception("No user found.");
		}
		return foundAgent;
	}

}