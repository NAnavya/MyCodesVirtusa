package org.vann.FourWheelerInsurance.model;

public class ForgotPassword
{
private String username;
private String newPassword;
public ForgotPassword() {
super();

}
public ForgotPassword(String username, String newPassword) {
super();
this.username = username;
this.newPassword = newPassword;
}
public String getUsername() {
return username;
}
public void setUsername(String username) {
this.username = username;
}
public String getNewPassword() {
return newPassword;
}
public void setNewPassword(String newPassword) {
this.newPassword = newPassword;
}

}