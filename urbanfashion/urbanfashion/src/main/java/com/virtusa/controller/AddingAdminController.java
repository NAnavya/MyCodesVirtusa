package com.virtusa.controller;

import java.sql.Connection;
import java.sql.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Logger;

import com.virtusa.entity.RegistrationEntity;
import com.virtusa.exception.PasswordException;
import com.virtusa.jdbc.DatabaseConnection;
import com.virtusa.service.RegistrationService;
import com.virtusa.service.RegistrationServiceImplementation;

public class AddingAdminController {

	Scanner sc;

	public void addAdmin(RegistrationEntity registration) {

		Logger logger = Logger.getLogger(AddingAdminController.class.getName());
		sc = new Scanner(System.in);
		try {

			Connection connection = DatabaseConnection.getConnection();
			RegistrationService service = new RegistrationServiceImplementation();

			logger.info("Enter UserName");
			registration.setUsername(sc.nextLine());

			logger.info("Enter Email Id");
			registration.setUseremail(sc.next());

			logger.info("Enter Password");
			registration.setPassword(sc.next());

			logger.info("Confirm Password");
			registration.setConfirmpassword(sc.next());

			if (registration.getPassword().equals(registration.getConfirmpassword())) {

				logger.info("Enter User D.O.B");
				String str = sc.next();
				Date dob = Date.valueOf(str);
				registration.setUserdob(dob);

				registration.setUserrole("admin");

				service.registerUsers(connection, registration);
			} else {
				throw new PasswordException(
						"Password and Confirm Password Not matched " + "\n" + "Registration Failed" + "\n");
			}
		} catch (IllegalArgumentException | InputMismatchException  e) {
			logger.info("Enter values according to fields");
		}
		catch (PasswordException pe) {
			logger.info(pe.getMessage());
		}

	}

}
