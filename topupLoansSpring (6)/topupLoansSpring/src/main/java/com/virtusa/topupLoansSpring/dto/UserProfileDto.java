package com.virtusa.topupLoansSpring.dto;

public class UserProfileDto {
    private int userid;
    private String aadhar;
    private long salary;
    private String pan;
    private String address;
    private String name;
    public UserProfileDto() {
        super();
        // TODO Auto-generated constructor stub
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
		return "UserProfileDto [userid=" + userid + ", aadhar=" + aadhar + ", salary=" + salary + ", pan=" + pan
				+ ", address=" + address + ", name=" + name + "]";
	}

}
