package com.virtusa.UrbanFashionSpringBoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.UrbanFashionSpringBoot.dao.ProductRepository;
import com.virtusa.UrbanFashionSpringBoot.dao.RegistrationRepository;
import com.virtusa.UrbanFashionSpringBoot.dao.RetailerRepository;
import com.virtusa.UrbanFashionSpringBoot.exception.EmailException;
import com.virtusa.UrbanFashionSpringBoot.exception.ExistException;
import com.virtusa.UrbanFashionSpringBoot.exception.ProductNotFoundException;
import com.virtusa.UrbanFashionSpringBoot.model.ProductModel;
import com.virtusa.UrbanFashionSpringBoot.model.RegistrationModel;
import com.virtusa.UrbanFashionSpringBoot.model.RetailerModel;

@Service
public class AdminServiceImplementation implements AdminService {

	@Autowired
	RegistrationRepository rrepo;

	@Autowired
	ProductRepository prepo;

	@Autowired
	RetailerRepository rerepo;

	RegistrationModel rmodel = new RegistrationModel();
	RetailerModel remodel = new RetailerModel();


	@Override
	public String addAdmin(RegistrationModel model) {

		String a = "fail";
		try {
			if(!(rrepo.existsByUemail(model.getUemail()))) {
				if(model.getPassword().equals(model.getCpassword())) {
					model.setRole("admin");
					rrepo.save(model);
					a = "pass";
				}
				else
					a = "fail";
			}
			else
				throw new EmailException("Email Already Exist");
		}
		catch(EmailException e) {
			a = e.getMessage();
		}
		return a;
	}

	@Override
	public List<RegistrationModel> viewAll() {
		return rrepo.findAll();
	}

	@Override
	public List<RegistrationModel> viewUsers() {
		return (rrepo.findByRole("user"));



	}

	@Override
	public List<RegistrationModel> viewAdmins() {
		return rrepo.findByRole("admin");
	}

	@Override
	public String addProducts(String uemail , int pcode,ProductModel model) {
		String res = null;
		try {
			if(rrepo.existsByUemail(uemail)) {
				if(rerepo.existsByPcode(pcode)) {
					rmodel = rrepo.findByUemail(uemail);
					remodel = rerepo.findByPcode(pcode);
					if(!(prepo.existsByPcode(remodel))) {
						model.setPname(remodel.getPname());
						model.setPcompany(remodel.getPcompany());
						model.setPcode(remodel);
						model.setUid(rmodel);
						model.setOcost(remodel.getPcost());
						model.setBalance(model.getScost()-model.getOcost());
						if(model.getPquantity() > remodel.getPquantity())
							throw new ExistException("Retailers Quantity limit exceeded");
						else {
							remodel.setPquantity(remodel.getPquantity()-model.getPquantity());
							prepo.save(model);
							rerepo.save(remodel);
							throw new ExistException("Product Added");
						}
					}
					else {
						updateProducts(model,remodel);
					}
				}
				else
					throw new ProductNotFoundException("Product Not Found");
			}
			else
				throw new EmailException("Email doesn't Exist");
		}
		catch (ExistException e) {
			res = e.getMessage();
		}
		catch(ProductNotFoundException e) {
			res = e.getMessage();
		}
		catch(EmailException e) {
			res = e.getMessage();
		}
		return res;

	}

	@Override
	public String updateProducts(ProductModel model, RetailerModel remodel2) {
		ProductModel pm = new ProductModel();
		pm = prepo.findByPcode(remodel);
		if(model.getPquantity() > remodel.getPquantity())
			throw new ExistException("Retailers Quantity limit exceeded");
		else {
			remodel.setPquantity(remodel.getPquantity()-model.getPquantity());
			pm.setPquantity(pm.getPquantity()+model.getPquantity());
			prepo.save(pm);
			rerepo.save(remodel);
			throw new ExistException("Product Updated");
		}
	}
}