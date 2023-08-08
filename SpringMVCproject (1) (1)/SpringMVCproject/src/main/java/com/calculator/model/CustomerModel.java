package com.calculator.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customerdb")
public class CustomerModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int customerId;
	@Column(nullable = false)
	private String customerName;
	@Column(nullable = false)
	private String customerMobile;
	@Column(nullable = false)
	private String customerEmail;
	@Column(nullable = false)
	private String customerPassword;
	@Column(nullable = false)
	private String role;
	
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerMobile() {
		return customerMobile;
	}

	public void setCustomerMobile(String customerMobile) {
		this.customerMobile = customerMobile;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerPassword() {
		return customerPassword;
	}

	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}
	
	

	public CustomerModel( String customerName, String customerMobile, String customerEmail,
			String customerPassword, String role) {
		super();
		
		this.customerName = customerName;
		this.customerMobile = customerMobile;
		this.customerEmail = customerEmail;
		this.customerPassword = customerPassword;
		this.role = role;
	}

	public CustomerModel() {
		
	}

}
