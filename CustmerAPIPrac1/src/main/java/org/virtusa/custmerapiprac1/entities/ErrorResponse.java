package org.virtusa.custmerapiprac1.entities;

import java.time.LocalDateTime;

public class ErrorResponse {
	private int statuscode;
	private String errorMessage;
	private LocalDateTime timeStamp;
	
	public ErrorResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ErrorResponse(int statuscode, String errorMessage, LocalDateTime timeStamp) {
		super();
		this.statuscode = statuscode;
		this.errorMessage = errorMessage;
		this.timeStamp = timeStamp;
	}
	public int getStatuscode() {
		return statuscode;
	}
	public void setStatuscode(int statuscode) {
		this.statuscode = statuscode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}
	

}
