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
import com.Capstone.service.AgentService;




@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class AgentController {
	
	@Autowired
	AgentService agentService;



	@RequestMapping(
	    		value = "/AgentSignUp",
	    		consumes = MediaType.APPLICATION_JSON_VALUE,
	    		produces = MediaType.APPLICATION_JSON_VALUE,
	    		method = RequestMethod.POST
	    		)
	
	@ResponseBody
	    public ResponseEntity<Object> AgentSignUp(@RequestBody Agent agent) {
		 try {
	            Agent signedUpUser = agentService.save(agent);
	    
	            // Give proper status codes, OK 200, BadRequest 400, INTERNAL_SERVER_ERROR 500
	            return new ResponseEntity<>(signedUpUser, HttpStatus.OK);
	        } catch(Exception e) {
	            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
	        } catch(Error e) {
	            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    	
		}
	@RequestMapping(
    		value = "/AgentSignIn",
    		method = RequestMethod.POST
    		)

@ResponseBody
    public ResponseEntity<Object> AgentSignIn(@RequestBody Agent agent) {
	 try {
		  
            Agent someAgent = agentService.agentSignIn(agent);
    
            // Give proper status codes, OK 200, BadRequest 400, INTERNAL_SERVER_ERROR 500
            return new ResponseEntity<>(someAgent, HttpStatus.OK);
        } catch(Exception e) {
        	 System.out.println(e.getMessage());
       	  
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        } catch(Error e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}