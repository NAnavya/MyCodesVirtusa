package org.vann.FourWheelerInsurance.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class FeedBack {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int customerId;
	private String name;
	private String emailId;
	private long phoneNumber;
	@Column(length = 3000)
	private String feedBackgiven;
	@CreationTimestamp
	private LocalDateTime createdDateTime;
	public FeedBack() {
		super();

	}
	public String getFeedBackgiven() {
		return feedBackgiven;
	}
	public void setFeedBackgiven(String feedBackgiven) {
		this.feedBackgiven = feedBackgiven;
	}
	public FeedBack(int id, int customerId, String name, String emailId, long phoneNumber, String feedBackgiven) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.name = name;
		this.emailId = emailId;
		this.phoneNumber = phoneNumber;
		this.feedBackgiven = feedBackgiven;
	}
	public FeedBack(int id, int customerId, String name, String emailId, long phoneNumber, String feedBackgiven,
			LocalDateTime createdDateTime) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.name = name;
		this.emailId = emailId;
		this.phoneNumber = phoneNumber;
		this.feedBackgiven = feedBackgiven;
		this.createdDateTime = createdDateTime;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
	public LocalDateTime getCreatedDateTime() {
		return createdDateTime;
	}
	public void setCreatedDateTime(LocalDateTime createdDateTime) {
		this.createdDateTime = createdDateTime;
	}
	
}
