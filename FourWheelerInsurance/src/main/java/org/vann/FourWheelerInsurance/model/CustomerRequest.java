package org.vann.FourWheelerInsurance.model;

import java.util.List;

public class CustomerRequest
{
private int id;
private String name;
private String emailId;
private long phoneNumber;
private String username;
private String password;
private List<String> roles;
public CustomerRequest(int id, String name, String emailId, long phoneNumber, String username, String password,
List<String> roles) {
super();
this.id = id;
this.name = name;
this.emailId = emailId;
this.phoneNumber = phoneNumber;
this.username = username;
this.password = password;
this.roles = roles;
}
public CustomerRequest() {
super();
}
public int getId() {
return id;
}
public void setId(int id) {
this.id = id;
}
public String getName() {
return name;
}
public void setName(String name) {
this.name = name;
}
public String getEmailId() {
return emailId;
}
public void setEmailId(String emailId) {
this.emailId = emailId;
}
public long getPhoneNumber() {
return phoneNumber;
}
public void setPhoneNumber(long phoneNumber) {
this.phoneNumber = phoneNumber;
}
public String getUsername() {
return username;
}
public void setUsername(String username) {
this.username = username;
}
public String getPassword() {
return password;
}
public void setPassword(String password) {
this.password = password;
}
public List<String> getRoles() {
return roles;
}
public void setRoles(List<String> roles) {
this.roles = roles;
}


}