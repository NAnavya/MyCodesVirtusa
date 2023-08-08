package com.vir.online_banking_app.dto;

public class AccountDto {
	private long accNo;
	private String accType;
	private float bal;
	private int userId;

	public AccountDto() {
		super();
	}

	public AccountDto(long accNo, String accType, float bal, int userId) {
		super();
		this.accNo = accNo;
		this.accType = accType;
		this.bal = bal;
		this.userId = userId;
	}

	public long getAccNo() {
		return accNo;
	}

	public void setAccNo(long accNo) {
		this.accNo = accNo;
	}

	public String getAccType() {
		return accType;
	}

	public void setAccType(String accType) {
		this.accType = accType;
	}

	public float getBal() {
		return bal;
	}

	public void setBal(float bal) {
		this.bal = bal;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "AccountDto [accNo=" + accNo + ", accType=" + accType + ", bal=" + bal + ", userId=" + userId + "]";
	}

}
