package org.vann.FourWheelerInsurance.model;

import java.util.List;

public class CustomerResponse {
private String token;
private List<String> roles;
private int customerId;
public CustomerResponse() {
super();
}
public CustomerResponse(String token, List<String> roles, int customerId) {
super();
this.token = token;
this.roles = roles;
this.customerId = customerId;
}
public String getToken() {
return token;
}
public void setToken(String token) {
this.token = token;
}
public List<String> getRoles() {
return roles;
}
public void setRoles(List<String> roles) {
this.roles = roles;
}
public int getCustomerId() {
return customerId;
}
public void setCustomerId(int customerId) {
this.customerId = customerId;
}
}
