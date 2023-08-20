package com.virtusa.UrbanFashionSpringBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.UrbanFashionSpringBoot.model.RegistrationModel;
import com.virtusa.UrbanFashionSpringBoot.service.RegistrationService;

@RestController
@RequestMapping("/register")
public class RegistrationController {
	
	@Autowired
	RegistrationService serv; 
	
	@PostMapping("/add")
	public ResponseEntity<String> addUers(@RequestBody RegistrationModel model) {
		if(serv.addUsers(model).equals("pass"))
			return new ResponseEntity<>("Registration Successful",HttpStatus.OK);
		else if(serv.addUsers(model).equals("fail"))
			return new ResponseEntity<>("Registration UnSuccessful,Password and Confirm Password not match",HttpStatus.BAD_REQUEST);
		else
			return new ResponseEntity<>(serv.addUsers(model),HttpStatus.BAD_REQUEST);
	}
	
	
}