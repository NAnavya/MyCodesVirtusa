package org.vann.FourWheelerInsurance.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.vann.FourWheelerInsurance.model.CustomerRequest;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Customer
{
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;


private String name;


private String emailId;


private long phoneNumber;


private String username;


private String password;

@OneToMany(mappedBy = "customer",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
@JsonIgnore
private Set<Role> roles = new HashSet<>();

public Customer() {
super();
}
public Customer(int id, String name, String emailId, long phoneNumber, String username, String password) {
super();
this.id = id;
this.name = name;
this.emailId = emailId;
this.phoneNumber = phoneNumber;
this.username = username;
this.password = password;
}

public Customer(int id, String name, String emailId, long phoneNumber, String username, String password,
Set<Role> roles) {
super();
this.id = id;
this.name = name;
this.emailId = emailId;
this.phoneNumber = phoneNumber;
this.username = username;
this.password = password;
this.roles = roles;
}
public Customer(CustomerRequest customerRequest) {

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
public Set<Role> getRoles() {
return roles;
}
public void setRoles(Set<Role> roles) {
this.roles = roles;
}
@Override
public String toString() {
return "Customer [id=" + id + ", name=" + name + ", emailId=" + emailId + ", phoneNumber=" + phoneNumber
+ ", username=" + username + ", password=" + password + ", roles=" + roles + "]";
}

}