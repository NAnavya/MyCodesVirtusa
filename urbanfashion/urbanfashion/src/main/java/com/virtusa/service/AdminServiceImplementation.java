package com.virtusa.service;

import java.util.Scanner;
import java.util.logging.Logger;

import javax.naming.LimitExceededException;

import com.virtusa.entity.RegistrationEntity;
import com.virtusa.exception.CartDoesNotExistException;
import com.virtusa.exception.UserException;
import com.virtusa.repository.AdminRepository;
import com.virtusa.repository.UserRepository;

public class AdminServiceImplementation implements AdminService {

	AdminRepository repo = new AdminRepository();
	UserRepository usrepo = new UserRepository();
	Scanner sc = new Scanner(System.in);
	Logger logger = Logger.getLogger(AdminServiceImplementation.class.getName());

	@Override
	public void viewAllUsers(RegistrationEntity registration) {

		try {

			if(repo.usersExist()) {
					logger.log(java.util.logging.Level.SEVERE, "{0}", repo.viewUsers());

			}
			else
				throw new UserException("Users Not Found!");
		}
		catch(UserException e) {
			logger.info(e.getMessage());
		}

	}

	@Override
	public void updateUsers(RegistrationEntity registration) {
		try {
		logger.info("Enter email id to update");
		String checkemail = sc.next();
		if(repo.findUserByEmailId(checkemail)) {
			if(repo.viewUserByEmailId(checkemail))
				repo.updateUserByEmailIdFromAdmin(checkemail);
		}
		else
			throw new UserException("User Not Found");
		}
		catch(UserException e) {
			logger.info(e.getMessage());
		}
		
	}

	@Override
	public void deleteUsers() {
		
		logger.info("Enter Email to be deleted");
		String checkemail = sc.next();
		if(repo.findUserByEmailId(checkemail)) {
			usrepo.deleteProfile(checkemail);
		}
		else{
			logger.info("User Not Found with email!");
			logger.log(java.util.logging.Level.SEVERE, "{0}", checkemail);
		}
	}

	@Override
	public void viewUsersWithCart() {
		
		try {

			if(repo.usersExist()) {
				if(repo.cartExist()) {

				repo.viewUsersWithCart();

			}
				else throw new CartDoesNotExistException("Cart is empty to display with userid");
			}
			else
				throw new UserException("Users Not Found!!");
		}
		catch(UserException | CartDoesNotExistException e) {
			logger.info(e.getMessage());
		}
		
	}

	@Override
	public void sortUsersByName() {
		try {

			if(repo.usersExist()) {

				repo.sortUsersByName();

			}
			else
				throw new UserException("Users Not Found");
		}
		catch(UserException e) {
			logger.info(e.getMessage());
		}
		
	}

	@Override
	public void viewUsersByLimit() {
		try {

			if(repo.usersExist()) {
				logger.info("Enter no of records to be print!");
				int nr = sc.nextInt();
				if(repo.viewUsersByLimit(nr)) {
					logger.info("executed");
				}
				else
					throw new LimitExceededException("Limit Exceeded");

			}
			else
				throw new UserException("Users Not Found");
		}
		catch(UserException | LimitExceededException e) {
			logger.info(e.getMessage());
		}
	}


}
