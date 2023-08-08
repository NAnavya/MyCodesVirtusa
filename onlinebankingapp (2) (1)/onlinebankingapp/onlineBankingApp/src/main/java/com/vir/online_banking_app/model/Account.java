package com.vir.online_banking_app.model;

import java.time.LocalDateTime;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;

	@Column(unique = true)
	private long accNo;

	@CreationTimestamp
	private LocalDateTime opendate;
	private String accType;
	private float bal;
	@OneToOne(cascade = CascadeType.ALL)
	private User user;

	public Account() {
		super();
	}

	public Account(long id, long accNo, LocalDateTime opendate, String accType, float bal, User user) {
		super();
		this.id = id;
		this.accNo = accNo;
		this.opendate = opendate;
		this.accType = accType;
		this.bal = bal;
		this.user = user;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getAccNo() {
		return accNo;
	}

	public void setAccNo(long accNo) {
		this.accNo = accNo;
	}

	public LocalDateTime getOpendate() {
		return opendate;
	}

	public void setOpendate(LocalDateTime opendate) {
		this.opendate = opendate;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
