package org.vann.FourWheelerInsurance.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Orderitems
{
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int orderid;
private int customerid;
private String policyName;
private String claimAmount;
private int policyPrice;
private int numberOfYearsPlan;
private String policydetails;
@CreationTimestamp
private LocalDateTime createdDateTime;
public Orderitems() {
super();

}
public Orderitems(int orderid, int customerid, String policyName, String claimAmount, int policyPrice,
int numberOfYearsPlan, String policydetails, LocalDateTime createdDateTime) {
super();
this.orderid = orderid;
this.customerid = customerid;
this.policyName = policyName;
this.claimAmount = claimAmount;
this.policyPrice = policyPrice;
this.numberOfYearsPlan = numberOfYearsPlan;
this.policydetails = policydetails;
this.createdDateTime = createdDateTime;
}
public int getOrderid() {
return orderid;
}
public void setOrderid(int orderid) {
this.orderid = orderid;
}
public int getCustomerid() {
return customerid;
}
public void setCustomerid(int customerid) {
this.customerid = customerid;
}
public String getPolicyName() {
return policyName;
}
public void setPolicyName(String policyName) {
this.policyName = policyName;
}
public String getClaimAmount() {
return claimAmount;
}
public void setClaimAmount(String claimAmount) {
this.claimAmount = claimAmount;
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
public String getPolicydetails() {
return policydetails;
}
public void setPolicydetails(String policydetails) {
this.policydetails = policydetails;
}
public LocalDateTime getCreatedDateTime() {
return createdDateTime;
}
public void setCreatedDateTime(LocalDateTime createdDateTime) {
this.createdDateTime = createdDateTime;
}
@Override
public String toString() {
return "Orderitems [orderid=" + orderid + ", customerid=" + customerid + ", policyName=" + policyName
+ ", claimAmount=" + claimAmount + ", policyPrice=" + policyPrice + ", numberOfYearsPlan="
+ numberOfYearsPlan + ", policydetails=" + policydetails + ", createdDateTime=" + createdDateTime + "]";
}


}