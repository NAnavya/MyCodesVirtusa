package org.virtusa.custmerapiprac1.entities;

import java.time.LocalDate;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass //MappedSuperclass means the child which is extending this class can only get the these properties
@EntityListeners(AuditingEntityListener.class)
public class AuditTable<U> {
	@CreatedBy
	private U createdBy;
	@CreatedDate
	//@Temporal(TIMESTAMP)  but here we are using LocalDate
	private LocalDate createdDate;
	@LastModifiedBy
	private U lastModifiedBy;
	@LastModifiedDate
	//@Temporal(TIMESTAMP)
	private LocalDate lastModifiedDate;
	public AuditTable(U createdBy, LocalDate createdDate, U lastModifiedBy, LocalDate lastModifiedDate) {
		super();
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.lastModifiedBy = lastModifiedBy;
		this.lastModifiedDate = lastModifiedDate;
	}
	public AuditTable() {
		super();
		// TODO Auto-generated constructor stub
	}
	public U getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(U createdBy) {
		this.createdBy = createdBy;
	}
	public LocalDate getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}
	public U getLastModifiedBy() {
		return lastModifiedBy;
	}
	public void setLastModifiedBy(U lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}
	public LocalDate getLastModifiedDate() {
		return lastModifiedDate;
	}
	public void setLastModifiedDate(LocalDate lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
}
