package com.virtusa.service;

import com.virtusa.entity.RegistrationEntity;

public interface AdminService {

	void viewAllUsers(RegistrationEntity registration);

	void updateUsers(RegistrationEntity registration);

	void deleteUsers();

	void viewUsersWithCart();

	void sortUsersByName();

	void viewUsersByLimit();


		
	
}
