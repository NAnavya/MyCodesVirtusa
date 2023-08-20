package com.virtusa.course.controller;

import java.text.ParseException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.course.entities.RegisteredCourse;
import com.virtusa.course.service.RegistrationService;

@RestController
@RequestMapping("/registration")
public class RegisteredController {
	@Autowired 
	RegistrationService regser;
	
	@PostMapping
	public ResponseEntity<String> addReg(@Valid @RequestBody RegisteredCourse rc){
		String str=regser.addRegs(rc);
		return ResponseEntity.ok(str);
		
	}
	
	@PutMapping("{id}")
	public ResponseEntity<String> upReg(@Valid @RequestBody RegisteredCourse rc,@PathVariable("id") int id){
		String str=regser.upRegs(rc,id);
		return ResponseEntity.ok(str);
		
	}
	@PatchMapping("{id}")
	public ResponseEntity<String> upRegDate(@Valid @RequestParam String date,@PathVariable int id) throws ParseException{
	    String str=regser.patRegs(date,id);
	    return ResponseEntity.ok(str);
	}
	
	

}
