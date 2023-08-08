package org.virtusa.custmerapiprac1.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;




//Here we are using lombook to avoid boilerplate code
@Entity
public class Customer extends AuditTable<String> {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int cid;
	private String customerName;
	private String customerAddress;
	private LocalDate dateOfBirth;
	public Customer(int cid, String customerName, String customerAddress, LocalDate dateOfBirth) {
		super();
		this.cid = cid;
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.dateOfBirth = dateOfBirth;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

}
