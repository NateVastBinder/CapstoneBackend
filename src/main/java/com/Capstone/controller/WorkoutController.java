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
import com.Capstone.entity.MuscleGroup;
import com.Capstone.entity.User;
import com.Capstone.entity.Workout;
import com.Capstone.service.MuscleGroupService;
import com.Capstone.service.UserService;
import com.Capstone.service.WorkoutService;



@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class WorkoutController {
	
	@Autowired
	WorkoutService workoutService;
	
	@Autowired
	UserService userService;
	@Autowired
	MuscleGroupService muscleGroupService;



	@RequestMapping(
	    		value = "/AddWorkout",
	    		consumes = MediaType.APPLICATION_JSON_VALUE,
	    		produces = MediaType.APPLICATION_JSON_VALUE,
	    		method = RequestMethod.POST
	    		)
	
	@ResponseBody
	    public ResponseEntity<Object> AddWorkout(@RequestBody Workout workout) {
		 try {
	            Workout newWorkout = workoutService.save(workout);
	    
	            // Give proper status codes, OK 200, BadRequest 400, INTERNAL_SERVER_ERROR 500
	            return new ResponseEntity<>(newWorkout, HttpStatus.OK);
	        } catch(Exception e) {
	            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
	        } catch(Error e) {
	            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    	
		}
	
	@RequestMapping(
    		value = "/getAllWorkouts",
    		method = RequestMethod.GET
    		)
@ResponseBody
    public ResponseEntity<Object> getAllWorkouts() {
	 try {
		  
            List<Workout> workouts = workoutService.getAll();
    
            // Give proper status codes, OK 200, BadRequest 400, INTERNAL_SERVER_ERROR 500
            return new ResponseEntity<>(workouts, HttpStatus.OK);
        } catch(Exception e) {
        	 System.out.println(e.getMessage());
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        } catch(Error e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    	
	}
	
	@RequestMapping(
    		value = "/AddWorkout/{muscleGroupName}",
    		method = RequestMethod.POST
    		)
@ResponseBody
    public ResponseEntity<Object> addWorkuot(@RequestBody User user, @PathVariable String muscleGroupName) {
	 try {
		 
		 	List<MuscleGroup> muscleGroupList = muscleGroupService.getByMuscleGroup(muscleGroupName);
		 	
		 	for(MuscleGroup muscle : muscleGroupList) {

		 		userService.addWorkout(user, muscle);
			 	
		 	}	
		  
    
            // Give proper status codes, OK 200, BadRequest 400, INTERNAL_SERVER_ERROR 500
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch(Exception e) {
        	 System.out.println(e.getMessage());
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        } catch(Error e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    	
	}
}