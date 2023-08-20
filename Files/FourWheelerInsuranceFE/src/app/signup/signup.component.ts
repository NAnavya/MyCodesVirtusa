import { Component, OnInit } from '@angular/core';
import { NgForm, NgModel } from '@angular/forms';
import { Router } from '@angular/router';
import { Customer } from '../models/customer.model';
import { AuthenticationService } from '../services/authentication.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  successMessage : string = "";
  errorMessage : string = "";

  constructor(private router:Router,private authService:AuthenticationService) { }

  ngOnInit(): void {
  }

  NaviateToLogin(){ 
      this.router.navigate(["/"]);
  }

  //to register the new user for the web application.
  signUp(signupform:NgForm){
    const customer:Customer = {
    name : signupform.value.customername,
    emailId : signupform.value.emailid,
    phoneNumber : signupform.value.mobilenumber,
    username : signupform.value.username,
    password : signupform.value.password,
    roles  : ["USER"]
    }

    this.authService.registerUser(customer).subscribe((response)=>{
      if(response["statusCode"] >=400 &&  response["statusCode"]<=499 ){
        this.errorMessage = response["errorMessage"] + " Please Login";
      }
      else{
        this.successMessage = "Registration Successfully";
      }

    },(error)=>{
      console.log(error);
      this.errorMessage = "Something Went Wrong in Registration Process";
    });
  }

}
