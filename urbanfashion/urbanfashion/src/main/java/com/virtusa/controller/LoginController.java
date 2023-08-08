package com.virtusa.controller;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Logger;

import com.virtusa.service.LoginService;
import com.virtusa.service.LoginServiceImplementation;


public class LoginController {
	
	Scanner sc;
	public void login() {
		
		sc = new Scanner(System.in);
		Logger logger = Logger.getLogger(LoginController.class.getName());
		LoginService service = new LoginServiceImplementation();
		try {
		logger.info("Enter Email : ");
		String str1 = sc.next();
		logger.info("Enter Password : ");
		String str2 = sc.next();
		service.validateUser(str1,str2);
		}
		catch(InputMismatchException e) {
			logger.info("Enter values according to fields");
		}
		
	}

}
