package com.virtusa.UrbanFashionSpringBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.UrbanFashionSpringBoot.model.RetailerModel;
import com.virtusa.UrbanFashionSpringBoot.service.RetailerService;

@RestController
@RequestMapping("/retailer")
public class RetailerController {
	
	@Autowired
	RetailerService rserv;
	
	@PostMapping("/addProducts")
	public ResponseEntity<String> addProducts(@RequestBody RetailerModel model) {
			return new ResponseEntity<String>(rserv.addProducts(model),HttpStatus.OK);
	}
	
}
