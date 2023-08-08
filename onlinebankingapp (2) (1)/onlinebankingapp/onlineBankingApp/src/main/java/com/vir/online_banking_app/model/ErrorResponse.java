package com.vir.online_banking_app.model;

import java.time.LocalDateTime;

public class ErrorResponse {
	private int statusCode;
	private String errorMessage;
	private LocalDateTime date;
	public ErrorResponse(int statusCode, String errorMessage, LocalDateTime date) {
		super();
		this.statusCode = statusCode;
		this.errorMessage = errorMessage;
		this.date = date;
	}
	public ErrorResponse() {
		super();
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "ErrorResponse [statusCode=" + statusCode + ", errorMessage=" + errorMessage + ", date=" + date + "]";
	}
	
}
