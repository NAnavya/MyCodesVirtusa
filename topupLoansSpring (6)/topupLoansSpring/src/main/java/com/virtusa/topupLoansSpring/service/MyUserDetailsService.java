package com.virtusa.topupLoansSpring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.virtusa.topupLoansSpring.entities.User;
import com.virtusa.topupLoansSpring.repo.UserRepo;

@Service 
public class MyUserDetailsService implements UserDetailsService{

	@Autowired 
	private UserRepo repo;
	public UserDetails loadUserByEmail(String email) throws UsernameNotFoundException {
		User user=repo.findByEmail(email);
		return new UserPrinciple(user);
	}
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
