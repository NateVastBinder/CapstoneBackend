package com.Capstone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Capstone.entity.User;
import com.Capstone.repo.UserRepo;

@Service
public class UserService {

	@Autowired
	UserRepo userRepo;
	
	public User save(User user) {

		return userRepo.save(user);
	}

	public User signIn(User user) throws Exception {
		  
		User foundUser = userRepo.signIn(user.getEmail(), user.getPassword());
		  
		if (foundUser == null) {
			throw new Exception("No user found.");
		}
		return foundUser;
	}

	public User getUserByEmail(String email) throws Exception {
		User foundUser = userRepo.getUserByEmail(email);

		if(foundUser == null) {
			throw new Exception("No user found.");
		}

		return foundUser;
	}
	
	 public User getUserById(Integer userId) {
	    	if(userRepo.findById(userId).isPresent()) {
	    		return userRepo.findById(userId).get();
	    		}
	    	throw new Error("User not found");
	    }
}
