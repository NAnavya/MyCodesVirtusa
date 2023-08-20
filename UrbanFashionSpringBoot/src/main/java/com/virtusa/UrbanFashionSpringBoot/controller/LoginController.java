package com.virtusa.UrbanFashionSpringBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.UrbanFashionSpringBoot.model.RegistrationModel;
import com.virtusa.UrbanFashionSpringBoot.service.LoginService;

@RestController
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	LoginService lserv;
	
	@PostMapping("/user")
	public ResponseEntity<String> loginUser(@RequestBody RegistrationModel model){
		
		String res = lserv.loginUser(model);
		
		if(res.equals("pass1")) {
			return new ResponseEntity<>("Login successful", HttpStatus.OK);
		}
		if(res.equals("pass2"))
			return new ResponseEntity<>("Welcome Admin", HttpStatus.OK);
		else if(res.equals("fail"))
			return new ResponseEntity<>("Login Unsuccessful,Password Incorrect", HttpStatus.BAD_REQUEST);
		else
			return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
	}
	
}
