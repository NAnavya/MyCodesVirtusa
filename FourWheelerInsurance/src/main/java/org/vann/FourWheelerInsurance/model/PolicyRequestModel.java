package org.vann.FourWheelerInsurance.model;

public class PolicyRequestModel {
	private int pid;
	private String policyName;
	private int policyPrice;
	private int numberOfYearsPlan;
	private String claimAmount;
	

	public PolicyRequestModel() {
		super();
		
	}


	public int getId() {
		return pid;
	}
	

	public PolicyRequestModel(int pid, String policyName, int policyPrice, int numberOfYearsPlan, String claimAmount) {
		super();
		this.pid = pid;
		this.policyName = policyName;
		this.policyPrice = policyPrice;
		this.numberOfYearsPlan = numberOfYearsPlan;
		this.claimAmount = claimAmount;
	}

	public void setId(int id) {
		this.pid = id;
	}

	public String getPolicyName() {
		return policyName;
	}

	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}

	public int getPolicyPrice() {
		return policyPrice;
	}

	public void setPolicyPrice(int policyPrice) {
		this.policyPrice = policyPrice;
	}

	public int getNumberOfYearsPlan() {
		return numberOfYearsPlan;
	}

	public void setNumberOfYearsPlan(int numberOfYearsPlan) {
		this.numberOfYearsPlan = numberOfYearsPlan;
	}

	public String getClaimAmount() {
		return claimAmount;
	}

public void setClaimAmount(String claimAmount) {
this.claimAmount = claimAmount;
}

}


