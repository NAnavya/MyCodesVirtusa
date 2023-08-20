package com.virtusa.UrbanFashionSpringBoot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "products")
public class ProductModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pid;
	private String pname;
	private String pcompany;
	private int pquantity;
	private int ocost;
	private int scost;
	private int balance;
	@OneToOne
	@JsonIgnore
	@JoinColumn(name = "Retailers_pcode")
	private RetailerModel pcode;
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "Admin_aid")
	private RegistrationModel uid;
	
	
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
	public int getPquantity() {
		return pquantity;
	}
	public void setPquantity(int pquantity) {
		this.pquantity = pquantity;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	
	public RegistrationModel getUid() {
		return uid;
	}
	public void setUid(RegistrationModel uid) {
		this.uid = uid;
	}
	
	public String getPcompany() {
		return pcompany;
	}
	public void setPcompany(String pcompany) {
		this.pcompany = pcompany;
	}
	public RetailerModel getPcode() {
		return pcode;
	}
	public void setPcode(RetailerModel pcode) {
		this.pcode = pcode;
	}
	@Override
	public String toString() {
		return "ProductModel [pid=" + pid + ", pname=" + pname + ", pcompany=" + pcompany + ", pquantity=" + pquantity
				+ ", ocost=" + ocost + ", scost=" + scost + ", balance=" + balance + ", pcode=" + pcode + ", uid=" + uid
				+ "]";
	}
	
	
	

}
