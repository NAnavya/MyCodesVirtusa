package com.virtusa.topupLoansSpring.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.virtusa.topupLoansSpring.enums.LoanType;

//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;

//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
@Entity
public class Loan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Enumerated(EnumType.STRING)
	private LoanType loanType;
	@NotNull
	private long salary;
	@NotNull
	private int span;
	@NotNull
	private long amount_needed;
	private int emi;
	private String status;
    
	@ManyToOne
	private User user;
	public Loan() {
		super();
		// TODO Auto-generated constructor stub

	}	

	
	public Loan(int id, LoanType loanType, @NotNull long salary, @NotNull int span, @NotNull long amount_needed,
			int emi, String status, User user) {
		super();
		this.id = id;
		this.loanType = loanType;
		this.salary = salary;
		this.span = span;
		this.amount_needed = amount_needed;
		this.emi = emi;
		this.status = status;
		this.user = user;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public int getEmi() {
		return emi;
	}

	public void setEmi(int emi) {
		this.emi = emi;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LoanType getLoanType() {
		return loanType;
	}

	public void setLoanType(LoanType loanType) {
		this.loanType = loanType;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	public int getSpan() {
		return span;
	}

	public void setSpan(int span) {
		this.span = span;
	}

	public long getAmount_needed() {
		return amount_needed;
	}

	public void setAmount_needed(long amount_needed) {
		this.amount_needed = amount_needed;
	}


	@Override
	public String toString() {
		return "Loan [id=" + id + ", loanType=" + loanType + ", salary=" + salary + ", span=" + span
				+ ", amount_needed=" + amount_needed + ", emi=" + emi + ", status=" + status + ", user=" + user + "]";
	}

}
