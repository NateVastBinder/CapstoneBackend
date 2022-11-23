package com.Capstone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Capstone.entity.Agent;
import com.Capstone.entity.User;
import com.Capstone.entity.BodyPart;
import com.Capstone.service.UserService;
import com.Capstone.service.BodyPartService;



@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class BodyPartController {
	
	@Autowired
	BodyPartService bodyPartService;
	
	@Autowired
	UserService userService;



	@RequestMapping(
	    		value = "/AddBodyPart/{workoutId}",
	    		consumes = MediaType.APPLICATION_JSON_VALUE,
	    		produces = MediaType.APPLICATION_JSON_VALUE,
	    		method = RequestMethod.POST
	    		)
	
	@ResponseBody
	    public ResponseEntity<Object> AddBodyPart(@RequestBody BodyPart bodyPart, @PathVariable Integer workoutId) {
		 try {
	            BodyPart newBodyPart = bodyPartService.save(bodyPart, workoutId);
	    
	            // Give proper status codes, OK 200, BadRequest 400, INTERNAL_SERVER_ERROR 500
	            return new ResponseEntity<>(newBodyPart, HttpStatus.OK);
	        } catch(Exception e) {
	            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
	        } catch(Error e) {
	            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    	
		}
}