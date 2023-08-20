package org.vann.FourWheelerInsurance.entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.vann.FourWheelerInsurance.model.CartRequestModel;



@Entity
public class Cart {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)

@Column(nullable=false,updatable=false)
private int pid;
private int custid;
private String policyName;
private int  policyPrice;
private int numberOfYearsPlan;
private String claimAmount;

public Cart() {
super();

}

public Cart(int id, int custid, String policyName, int policyPrice, int numberOfYearsPlan, String claimAmount) {
super();
this.pid = id;
this.custid = custid;
this.policyName = policyName;
this.policyPrice = policyPrice;
this.numberOfYearsPlan = numberOfYearsPlan;
this.claimAmount = claimAmount;
}

public Cart(CartRequestModel cartRequestModel) {

}

public int getId() {
return pid;
}
public int getCustid() {
return custid;
}
public void setCustid(int custid) {
this.custid = custid;
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