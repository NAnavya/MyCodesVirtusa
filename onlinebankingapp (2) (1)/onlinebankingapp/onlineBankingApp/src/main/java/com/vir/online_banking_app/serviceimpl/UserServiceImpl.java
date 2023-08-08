package com.vir.online_banking_app.serviceimpl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vir.online_banking_app.dto.UserDto;
import com.vir.online_banking_app.exception.ResourceNotFoundException;
import com.vir.online_banking_app.model.User;
import com.vir.online_banking_app.repo.AccountRepo;
import com.vir.online_banking_app.repo.UserRepo;
import com.vir.online_banking_app.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepo userRepo;

	@Autowired
	public UserServiceImpl(UserRepo userRepo) {
		this.userRepo = userRepo;
	}

	@Autowired
	private AccountRepo accountRepo;

	ModelMapper mp = new ModelMapper();

	@Override
	public User addUser(UserDto user) {
		User us = mp.map(user, User.class);
		return this.userRepo.save(us);
	}

	@Override
	public void deleteUser(long id) {
		try {
			this.userRepo.deleteById(id);
		} catch (Exception e) {
			throw new ResourceNotFoundException("User Not Found");
		}
	}

	@Override
	public User updateUser(long id, UserDto user) {
		User us = this.userRepo.findById(id).orElseThrow(() -> new RuntimeException("Resource not found"));
		us.setAccount(accountRepo.findById(user.getAccount())
				.orElseThrow(() -> new ResourceNotFoundException("Account Not Found")));
		us.setEmail(user.getEmail());
		us.setName(user.getName());
		us.setPassword(user.getPassword());
		userRepo.save(us);
		return us;
	}

	@Override
	public User getUser(long id) {
		return this.userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User Not Found"));
	}

	@Override
	public List<User> getAllUsers() {
		return this.userRepo.findAll();
	}

}
