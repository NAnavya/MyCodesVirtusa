package com.virtusa.UrbanFashionSpringBoot.dto;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.virtusa.UrbanFashionSpringBoot.model.RegistrationModel;
import com.virtusa.UrbanFashionSpringBoot.model.RetailerModel;

public class ProductModelDto {
	private String pname;
	private String pcompany;
	private int pquantity;
	private int ocost;
	private int scost;
	private int balance;
	private int pcode;
	private int uid;
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPcompany() {
		return pcompany;
	}
	public void setPcompany(String pcompany) {
		this.pcompany = pcompany;
	}
	public int getPquantity() {
		return pquantity;
	}
	public void setPquantity(int pquantity) {
		this.pquantity = pquantity;
	}
	public int getOcost() {
		return ocost;
	}
	public void setOcost(int ocost) {
		this.ocost = ocost;
	}
	public int getScost() {
		return scost;
	}
	public void setScost(int scost) {
		this.scost = scost;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public int getPcode() {
		return pcode;
	}
	public void setPcode(int pcode) {
		this.pcode = pcode;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
}
