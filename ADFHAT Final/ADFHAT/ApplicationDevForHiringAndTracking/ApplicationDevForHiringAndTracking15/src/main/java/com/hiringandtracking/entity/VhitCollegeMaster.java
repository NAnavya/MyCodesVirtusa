package com.hiringandtracking.entity;

import jakarta.persistence.*;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

@Data
@Entity
public class VhitCollegeMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int vmcId;

    @NotBlank(message = "name cannot be Null or Empty")
    private String vmcName;

    @NotBlank(message = "address cannot be Null or Empty")
    private String vmcAddress;

    @NotBlank(message = "TPO_name cannot be Null or Empty")
    private String vmcTpoName;

    @Email(message = "TPO_mail should be a mail")
    @NotBlank(message = "TPO_mail cannot be Null or Empty")
    private String vmcTpoMail;


//    @NotBlank(message = "COE_MOU_Date cannot be Null or Empty")
    @DateTimeFormat(pattern="dd/MM/yyyy")
    private Date vmcCoeMouDate;

    @NotBlank(message = "city cannot be Null or Empty")
    private String vmcCity;

    @NotBlank(message = "state cannot be Null or Empty")
    private String vmcState;

//    @NotBlank(message = "PINCODE cannot be Null or Empty")
//    @Max(6)
    private int vmcPinCode;

    @NotBlank(message = "Status cannot be Null or Empty")
    private String vmcStatus;

	public int getVmcId() {
		return vmcId;
	}

	public void setVmcId(int vmcId) {
		this.vmcId = vmcId;
	}

	public String getVmcName() {
		return vmcName;
	}

	public void setVmcName(String vmcName) {
		this.vmcName = vmcName;
	}

	public String getVmcAddress() {
		return vmcAddress;
	}

	public void setVmcAddress(String vmcAddress) {
		this.vmcAddress = vmcAddress;
	}

	public String getVmcTpoName() {
		return vmcTpoName;
	}

	public void setVmcTpoName(String vmcTpoName) {
		this.vmcTpoName = vmcTpoName;
	}

	public String getVmcTpoMail() {
		return vmcTpoMail;
	}

	public void setVmcTpoMail(String vmcTpoMail) {
		this.vmcTpoMail = vmcTpoMail;
	}

	public Date getVmcCoeMouDate() {
		return vmcCoeMouDate;
	}

	public void setVmcCoeMouDate(Date vmcCoeMouDate) {
		this.vmcCoeMouDate = vmcCoeMouDate;
	}

	public String getVmcCity() {
		return vmcCity;
	}

	public void setVmcCity(String vmcCity) {
		this.vmcCity = vmcCity;
	}

	public String getVmcState() {
		return vmcState;
	}

	public void setVmcState(String vmcState) {
		this.vmcState = vmcState;
	}

	public int getVmcPinCode() {
		return vmcPinCode;
	}

	public void setVmcPinCode(int vmcPinCode) {
		this.vmcPinCode = vmcPinCode;
	}

	public String getVmcStatus() {
		return vmcStatus;
	}

	public void setVmcStatus(String vmcStatus) {
		this.vmcStatus = vmcStatus;
	}
    

}
