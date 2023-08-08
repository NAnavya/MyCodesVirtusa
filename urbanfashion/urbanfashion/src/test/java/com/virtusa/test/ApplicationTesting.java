package com.virtusa.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.virtusa.entity.ProductsEntity;
import com.virtusa.entity.RegistrationEntity;
import com.virtusa.repository.AdminRepository;
import com.virtusa.repository.ProductRepository;

public class ApplicationTesting {
	
	AdminRepository adrepo = new AdminRepository();
	ProductRepository prorepo = new ProductRepository();
	
	@Test
	public void positiveUserDetails() {
		List<RegistrationEntity> list = new ArrayList<>(adrepo.viewUsers());
		assertEquals(5,list.size());
		assertEquals(1,list.get(0).getUserid());
		assertEquals("admin",list.get(0).getUserrole());
	}
	@Test
	public void negativeUserDetails() {
		List<RegistrationEntity> list = new ArrayList<>(adrepo.viewUsers());
		assertNotEquals(4, list.size());
		assertNotEquals(2,list.get(0).getUserid());
		assertNotEquals("user",list.get(0).getUserrole());
	}
	@Test
	public void postiveProductDetails() {
		List<ProductsEntity> list = new ArrayList<>(prorepo.viewProducts());
		assertEquals(10,list.size());
		assertEquals(9,list.get(0).getProductid());
		assertEquals("white shirt",list.get(0).getProductname());
	}
	@Test
	public void negativeProductDetails() {
		List<ProductsEntity> list = new ArrayList<>(prorepo.viewProducts());
		assertNotEquals(5,list.size());
		assertNotEquals(1,list.get(0).getProductid());
		assertNotEquals("whiteshirt",list.get(0).getProductname());
	}
	
}
