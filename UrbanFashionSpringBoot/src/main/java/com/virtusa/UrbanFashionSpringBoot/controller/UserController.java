package com.virtusa.UrbanFashionSpringBoot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.UrbanFashionSpringBoot.model.CartItemsModel;
import com.virtusa.UrbanFashionSpringBoot.model.ProductModel;
import com.virtusa.UrbanFashionSpringBoot.model.RegistrationModel;
import com.virtusa.UrbanFashionSpringBoot.service.userService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	userService userv;

	@PutMapping("/edit/{uemail}")
	public ResponseEntity<RegistrationModel> editUser(@PathVariable String uemail,@RequestBody RegistrationModel model) {
		if(userv.editUser(uemail,model)!=null)
			return new ResponseEntity<RegistrationModel>(userv.editUser(uemail,model),HttpStatus.OK);
		else
			return new ResponseEntity<RegistrationModel>(userv.editUser(uemail,model),HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/view")
	public ResponseEntity<RegistrationModel> viewUser(@RequestParam String uemail){
		if(userv.viewUser(uemail)!=null)
			return new ResponseEntity<RegistrationModel>(userv.viewUser(uemail),HttpStatus.OK);
		else
			return new ResponseEntity<RegistrationModel>(userv.viewUser(uemail),HttpStatus.BAD_REQUEST);
	}

	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteUser(@RequestParam String uemail){
		if(userv.deleteUser(uemail))
			return new ResponseEntity<String>("deleted successfully",HttpStatus.OK);
		else
			return new ResponseEntity<String>("deletion Unsuccessfull,email doesn't exist",HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/viewProducts")
	public ResponseEntity<List<ProductModel>> viewProducts(){
		return new ResponseEntity<List<ProductModel>>(userv.viewProducts(),HttpStatus.OK);
	}
	
	@PostMapping("/addProducts/{uemail}/{pid}")
	public ResponseEntity<String> addPoductsToCart(@PathVariable String uemail,@PathVariable int pid,@RequestBody CartItemsModel cmodel) {
		return new ResponseEntity<String>(userv.addProductsToCart(uemail,pid,cmodel),HttpStatus.OK);
	}
	
}
