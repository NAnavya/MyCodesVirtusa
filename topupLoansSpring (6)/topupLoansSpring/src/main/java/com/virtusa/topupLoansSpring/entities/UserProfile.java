package com.virtusa.topupLoansSpring.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

 

//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
// 
//
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
@Entity
@Table(name="user_profile")
public class UserProfile {
   @Id
   private int userid;
   private String aadhar;
    private long salary;
    private String name;
    private String pan;
    private String address;
    

    public UserProfile() {
        super();
        // TODO Auto-generated constructor stub
    }


	public UserProfile(int userid, String aadhar, long salary, String name, String pan, String address) {
		super();
		this.userid = userid;
		this.aadhar = aadhar;
		this.salary = salary;
		this.name = name;
		this.pan = pan;
		this.address = address;
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getUserid() {
		return userid;
	}


	public void setUserid(int userid) {
		this.userid = userid;
	}


	public String getAadhar() {
        return aadhar;
    }
    public void setAadhar(String aadhar) {
        this.aadhar = aadhar;
    }

 

    public long getSalary() {
        return salary;
    }


    public void setSalary(long salary) {
        this.salary = salary;
    }

 

    public String getPan() {
        return pan;
    }

 

    public void setPan(String pan) {
        this.pan = pan;
    }

 

    public String getAddress() {
        return address;
    }

 

    public void setAddress(String address) {
        this.address = address;
    }


	@Override
	public String toString() {
		return "UserProfile [userid=" + userid + ", aadhar=" + aadhar + ", salary=" + salary + ", name=" + name
				+ ", pan=" + pan + ", address=" + address + "]";
	}






}