package com.virtusa.course.controller;



import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.course.entities.Admin;
import com.virtusa.course.repository.AdminRepo;
import com.virtusa.course.service.AdminService;


@RestController
@RequestMapping("/admin")
public class AdminController {
	Logger log=LoggerFactory.getLogger(AdminController.class);
	@Autowired
	AdminService adser;
	@PostMapping("/add")
	public ResponseEntity<String> addAdmin(@Valid @RequestBody Admin admin){
		String str=adser.addAdmin(admin);
		log.info("Added Successfully");
		return new ResponseEntity<>(str,HttpStatus.OK);
	}
}
