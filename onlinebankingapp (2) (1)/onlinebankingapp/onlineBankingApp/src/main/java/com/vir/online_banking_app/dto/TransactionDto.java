package com.vir.online_banking_app.dto;

import java.time.LocalDateTime;

public class TransactionDto {
	private long fromAcc;
	private long toAcc;
	private float amount;
	private LocalDateTime date;

	public long getFromAcc() {
		return fromAcc;
	}

	public void setFromAcc(long fromAcc) {
		this.fromAcc = fromAcc;
	}

	public long getToAcc() {
		return toAcc;
	}

	public void setToAcc(long toAcc) {
		this.toAcc = toAcc;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public TransactionDto(long fromAcc, long toAcc, float amount, LocalDateTime date) {
		super();
		this.fromAcc = fromAcc;
		this.toAcc = toAcc;
		this.amount = amount;
		this.date = date;
	}

	public TransactionDto() {
		super();
	}

	@Override
	public String toString() {
		return "TransactionDto [fromAcc=" + fromAcc + ", toAcc=" + toAcc + ", amount=" + amount + ", date=" + date
				+ "]";
	}

}
