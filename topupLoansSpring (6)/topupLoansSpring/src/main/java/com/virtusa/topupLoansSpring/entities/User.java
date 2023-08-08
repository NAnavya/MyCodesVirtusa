package com.virtusa.topupLoansSpring.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

 

import org.springframework.beans.factory.annotation.Value;

 

//import lombok.Data;
//
// 
//
//@Data
@Entity
@Table(name="User")
//NotNull means its value is not null but also accept the empty string or value also
//NotBlank means its value is not null and not an empty
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    //@Column(columnDefinition="VARCHAR(20) DEFAULT 'USER'")
    @NotBlank
    @Value("USER")
    private String role;
    @NotBlank(message= "Name cannot be null")
    private String name;
    @Email
    @NotBlank(message="Email cannot be null")
    private String email;
    @Pattern(regexp="(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%&+=])(?=\\S+$).{8,}$",message="Password must contain atleast one digit,one lowercase letter,one uppercase letter,one special character,no white spaces,and be atleast 8 characters long")
    private String password;

    private String conPassword;

    public User() {
        super();
        // TODO Auto-generated constructor stub
    }

 

    public User(int id, String role, String name, String email, String password, String conPassword) {
        super();
        this.id = id;
        this.role = role;
        this.name = name;
        this.email = email;
        this.password = password;
        this.conPassword = conPassword;
    }

 

    public int getId() {
        return id;
    }

 

    public void setId(int id) {
        this.id = id;
    }

 

    public String getRole() {
        return role;
    }

 

    public void setRole(String role) {
        this.role = role;
    }

 

    public String getName() {
        return name;
    }

 

    public void setName(String name) {
        this.name = name;
    }

 

    public String getEmail() {
        return email;
    }

 

    public void setEmail(String email) {
        this.email = email;
    }

 

    public String getPassword() {
        return password;
    }

 

    public CharSequence setPassword(String password) {
        return this.password = password;
    }

 

    public String getConPassword() {
        return conPassword;
    }

 

    public void setConPassword(String conPassword) {
        this.conPassword = conPassword;
    }

 

    @Override
    public String toString() {
        return "User [id=" + id + ", role=" + role + ", name=" + name + ", email=" + email + ", password=" + password
                + ", conPassword=" + conPassword + "]";
    }






}
