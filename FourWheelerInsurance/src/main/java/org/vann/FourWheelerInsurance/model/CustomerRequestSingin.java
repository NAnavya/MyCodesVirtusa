package org.vann.FourWheelerInsurance.model;


public class CustomerRequestSingin
{
private String username;
private String password;
public CustomerRequestSingin() {
super();
}
public CustomerRequestSingin(String username, String password) {
super();
this.username = username;
this.password = password;
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
}