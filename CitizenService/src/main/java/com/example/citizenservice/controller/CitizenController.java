package com.example.citizenservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.citizenservice.entities.Citizen;
import com.example.citizenservice.service.CitizenRepo;

@RestController
@RequestMapping("/citizen")
public class CitizenController {
	@Autowired
	CitizenRepo citRepo;
	
	@RequestMapping("/test")
	public ResponseEntity<String> test() {
		return new ResponseEntity<>("Hello",HttpStatus.OK);
		
	}
	
	@RequestMapping(path="/id/{id}")
	public ResponseEntity<List<Citizen>> getById(@PathVariable int id){
		List<Citizen> citizens=citRepo.findByVaccinationCenterId(id);
		return new ResponseEntity<>(citizens,HttpStatus.OK);
	}
	
	@PostMapping(path="/add")
	public ResponseEntity<Citizen> addCitizen(@RequestBody Citizen citizen){
		System.out.println();
		return new ResponseEntity<>(citRepo.save(citizen),HttpStatus.OK);
		
	}
	

}
