package com.hiringandtracking.dto;

import lombok.Data;

@Data
public class VhitCollegeMasterDto {

    String vmcName;
    String vmcAddress;
    String vmcTpoName;
    String vmcTpoMail;
    String vmcCoeMouDate;
    String vmcCity;
    String vmcState;
    int vmcPinCode;
    String vmcStatus;
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
	public String getVmcCoeMouDate() {
		return vmcCoeMouDate;
	}
	public void setVmcCoeMouDate(String vmcCoeMouDate) {
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
