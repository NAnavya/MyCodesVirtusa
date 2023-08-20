package com.virtusa.UrbanFashionSpringBoot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "retailer")
public class RetailerModel {
	
	@Id
	private int pcode;
	private int rid;
	private String rname;
	private String pname;
	private int pquantity;
	private String pcompany;
	private int pcost;
	
	
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public int getPcode() {
		return pcode;
	}
	public void setPcode(int pcode) {
		this.pcode = pcode;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getPquantity() {
		return pquantity;
	}
	public void setPquantity(int pquantity) {
		this.pquantity = pquantity;
	}
	public String getPcompany() {
		return pcompany;
	}
	public void setPcompany(String pcompany) {
		this.pcompany = pcompany;
	}
	public int getPcost() {
		return pcost;
	}
	public void setPcost(int pcost) {
		this.pcost = pcost;
	}
	
	@Override
	public String toString() {
		return "RetailerModel [rid=" + rid + ", rname=" + rname + ", pcode=" + pcode + ", pname=" + pname
				+ ", pquantity=" + pquantity + ", pcompany=" + pcompany + ", pcost=" + pcost + "]";
	}
	
	
	
}
