package com.vir.online_banking_app.dto;

public class UserDto {
	private String name;
	private String email;
	private String password;
	private long account;

	public UserDto() {
		super();
	}

	public UserDto(String name, String email, String password, long account) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.account = account;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getAccount() {
		return account;
	}

	public void setAccount(long account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "UserDto [name=" + name + ", email=" + email + ", password=" + password + ", acid=" + account + "]";
	}

}
