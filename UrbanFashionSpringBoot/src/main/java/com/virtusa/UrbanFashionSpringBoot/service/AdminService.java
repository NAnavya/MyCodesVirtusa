package com.virtusa.UrbanFashionSpringBoot.service;

import java.util.List;

import com.virtusa.UrbanFashionSpringBoot.model.ProductModel;
import com.virtusa.UrbanFashionSpringBoot.model.RegistrationModel;
import com.virtusa.UrbanFashionSpringBoot.model.RetailerModel;

public interface AdminService {

	String addAdmin(RegistrationModel model);

	List<RegistrationModel> viewAll();

     List<RegistrationModel> viewUsers();
     
	List<RegistrationModel> viewAdmins();

	String addProducts(String uemail , int pcode, ProductModel model);

	String updateProducts(ProductModel model, RetailerModel remodel);

//	boolean viewUsers();

}
