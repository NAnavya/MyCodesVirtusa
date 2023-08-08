package com.vir.online_banking_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;	
import org.springframework.web.bind.annotation.RestController;

import com.vir.online_banking_app.dto.UserDto;
import com.vir.online_banking_app.model.User;
import com.vir.online_banking_app.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
	
	private final UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService=userService;
	}

	@PostMapping("/addUser")
	public ResponseEntity<User> addUser(@RequestBody UserDto userdto) {
		return ResponseEntity.ok(userService.addUser(userdto));
	}

	@DeleteMapping("/deleteUser/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable long id) {
		this.userService.deleteUser(id);
		return ResponseEntity.ok("User successfully deleted");
	}

	@GetMapping("/getUser/{id}")
	public ResponseEntity<User> getUser(@PathVariable long id) {
		return ResponseEntity.ok(this.userService.getUser(id));
	}

	@PutMapping("/updateUser/{id}")
	public ResponseEntity<User> updateUser(@PathVariable long id, @RequestBody UserDto user) {
		return ResponseEntity.ok(this.userService.updateUser(id, user));
	}

}