package com.virtusa.UrbanFashionSpringBoot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.UrbanFashionSpringBoot.model.ProductModel;
import com.virtusa.UrbanFashionSpringBoot.model.RegistrationModel;
import com.virtusa.UrbanFashionSpringBoot.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	AdminService adserv;

	@PostMapping("/addAdmin")
	public ResponseEntity<String> addAdmin(@RequestBody RegistrationModel model) {
		String res = adserv.addAdmin(model);
		if(res.equals("pass"))
			return new ResponseEntity<>("Admin added successfully",HttpStatus.OK);
		else if(res.equals("fail"))
			return new ResponseEntity<>("Admin registration failed,Password and Confirm Password not match",HttpStatus.BAD_REQUEST);
		else
			return new ResponseEntity<>(res,HttpStatus.OK);
	}

	@GetMapping("/viewAll")
	public ResponseEntity<List<RegistrationModel>> viewAll(){
		return new ResponseEntity<>(adserv.viewAll(), HttpStatus.OK);
	}

	@GetMapping("/viewUsers")
	public ResponseEntity<List<RegistrationModel>> viewUsers(){
		return new ResponseEntity<>(adserv.viewUsers(), HttpStatus.OK);
	}
	
	@GetMapping("/viewAdmins")
	public ResponseEntity<List<RegistrationModel>> viewAdmins(){
		return new ResponseEntity<>(adserv.viewAdmins(), HttpStatus.OK);
	}
	
	@PostMapping("/addProducts/{uemail}/{pcode}")
	public ResponseEntity<String> addProducts(@PathVariable String uemail,@PathVariable int pcode,@RequestBody ProductModel model) {
		return new ResponseEntity<String>(adserv.addProducts(uemail,pcode,model),HttpStatus.OK);
	}
	
}

