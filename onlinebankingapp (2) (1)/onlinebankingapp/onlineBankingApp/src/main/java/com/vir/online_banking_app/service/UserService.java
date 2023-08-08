package com.vir.online_banking_app.service;

import java.util.List;

import com.vir.online_banking_app.dto.UserDto;
import com.vir.online_banking_app.model.User;

public interface UserService {

	public User addUser(UserDto user);
	public void deleteUser(long id);
	public User updateUser(long id,UserDto user);
	public User getUser(long id);
	public List<User> getAllUsers();
	
}
