package com.virtusa.course.entities;

import java.time.LocalDate;

public class ErrorResponse {
	private String message;
	private LocalDate date;
	private int statusCode;
	
	public ErrorResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ErrorResponse(String message, LocalDate date, int statusCode) {
		super();
		this.message = message;
		this.date = date;
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	

}
