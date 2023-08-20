package com.virtusa.UrbanFashionSpringBoot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.UrbanFashionSpringBoot.dao.RegistrationRepository;
import com.virtusa.UrbanFashionSpringBoot.exception.EmailException;
import com.virtusa.UrbanFashionSpringBoot.model.RegistrationModel;

@Service
public class RegistrationServiceImplementation implements RegistrationService {

	@Autowired
	RegistrationRepository rrepo;
	
	@Override
	public String addUsers(RegistrationModel model) {
		String a = null;
		try {
			//int count = rrepo.existsByUemail(model.getUemail());
			if(!(rrepo.existsByUemail(model.getUemail()))) {
				if(model.getPassword().equals(model.getCpassword())) {
					model.setRole("user");
					rrepo.save(model);
					a = "pass";
				}
				else
					a = "fail";
			}
			else
				throw new EmailException("Email Already Exists");
		}
	catch (EmailException e) {
			a = e.getMessage();
		}
		return a;
	}

}
