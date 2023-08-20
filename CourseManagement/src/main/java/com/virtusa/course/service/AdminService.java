package com.virtusa.course.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.course.entities.Admin;
import com.virtusa.course.exceptions.ResourceNotFoundException;
import com.virtusa.course.repository.AdminRepo;

@Service
public class AdminService {
	Logger log=LoggerFactory.getLogger(AdminService.class);
	@Autowired
	AdminRepo arepo;
	public String addAdmin(Admin admin) {
		String a="";
		if(!(arepo.existsById(admin.getId()))){
			arepo.save(admin);
			a="Added Successfully";
		}
		else {
			a="Admin Already Exist";
		    log.error("Admin Already Exist");
			throw new ResourceNotFoundException("Admin Already Exist");
		
		}
		return a;
		
	}

}
