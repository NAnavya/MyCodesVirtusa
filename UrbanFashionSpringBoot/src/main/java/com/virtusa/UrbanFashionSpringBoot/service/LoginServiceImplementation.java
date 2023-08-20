package com.virtusa.UrbanFashionSpringBoot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.UrbanFashionSpringBoot.dao.RegistrationRepository;
import com.virtusa.UrbanFashionSpringBoot.exception.UserNotExist;
import com.virtusa.UrbanFashionSpringBoot.model.RegistrationModel;

@Service
public class LoginServiceImplementation implements LoginService {
	
	
	@Autowired
	RegistrationRepository rrepo;
	
	RegistrationModel model1 = new RegistrationModel();
	
	@Override
	public String loginUser(RegistrationModel model) {
		
		String a = null;
		try {
//		int count = rrepo.existsByUemail(model.getUemail());
		if(rrepo.existsByUemail(model.getUemail())) {
//			String pass = rrepo.getPassword(model.getUemail());
			
			model1 = rrepo.findByUemail(model.getUemail());
			if(model1.getPassword().equals(model.getPassword())) {
				if(model1.getRole().equalsIgnoreCase("user"))
					a = "pass1";
				else
					a= "pass2";
			}
			else
				a = "fail";
		}
		else
			throw new UserNotExist("User not exist");
		}
		catch(UserNotExist e) {
			a = e.getMessage();
		}
		return a;
	}

}
