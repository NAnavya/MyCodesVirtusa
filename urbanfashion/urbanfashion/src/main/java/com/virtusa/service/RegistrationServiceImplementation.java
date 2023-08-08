package com.virtusa.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Logger;

import com.virtusa.entity.RegistrationEntity;
import com.virtusa.exception.UserException;
import com.virtusa.repository.RegistrationRepo;

public class RegistrationServiceImplementation implements RegistrationService {
	
	Logger logger = Logger.getLogger(RegistrationServiceImplementation.class.getName());
	RegistrationRepo registerrepo = new RegistrationRepo();
	public void registerUsers(Connection connection, RegistrationEntity registration){
		
		String useremail = registration.getUseremail();
		try {
			if(!(registerrepo.findUser(connection,useremail))) {
				registerrepo.registerUsers(connection,registration);
				throw new UserException("Registered Successfully");
			}
			else {
				throw new UserException("User Exists, User registered with this email already!"+"\n"
						+"Registration Failed"+"\n");
			}
		}
		catch(SQLException | UserException e) {
			logger.info(e.getMessage());
		}
		
	}

}

