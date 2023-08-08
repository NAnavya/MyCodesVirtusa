package com.virtusa.service;


import com.virtusa.controller.AdminController;
import com.virtusa.controller.UserController;
import com.virtusa.exception.UserException;
import com.virtusa.repository.LoginRepository;

public class LoginServiceImplementation implements LoginService {
	
	LoginRepository loginrepo = new LoginRepository();
	AdminController admincontrol = new AdminController();
	UserController usercontrol = new UserController();
	

	@Override
	public void validateUser(String str1, String str2){
		try {
			String str = loginrepo.check(str1,str2);
			if(str.equalsIgnoreCase("admin"))
				admincontrol.admin(str1);
			else if(str.equalsIgnoreCase("user"))
				usercontrol.user(str1);
			else
				throw new UserException("user not found");
		}
		catch(NullPointerException|UserException e) {
			e.getMessage();
		}
		
	}

}
