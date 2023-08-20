import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ForgotPassword } from '../models/forgot-password.model';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-forgot-password',
  templateUrl: './forgot-password.component.html',
  styleUrls: ['./forgot-password.component.css']
})
export class ForgotPasswordComponent implements OnInit {

  customerEmail:string="";
  isPresent:boolean;
  errorMessage:string;
  passwordErrorMessage:string;
  message:string;

  newPassword_temp:string;
  confirmPassword_temp:string;

  constructor(private customerService:UserService) { }
  
  ngOnInit(): void {
  }


  validateEmailId():void
  {
    this.customerService.validateEmail(this.customerEmail).subscribe((response)=>{
       this.isPresent = response;
     },(error)=>{
       this.isPresent = error.ok;
       this.errorMessage = "User with Emailid Doesn't Exist";
     });
  }
  

  resetPassword(form:NgForm){
      this.newPassword_temp = form.value.newpassword;
      this.confirmPassword_temp = form.value.confirmpassword;
      const username:string = form.value.username;
      if(this.newPassword_temp === this.confirmPassword_temp){
         const forgotPasswordRequest:ForgotPassword = {
           username : username,
           newPassword : this.newPassword_temp
         }
         this.customerService.resetPassword(forgotPasswordRequest).subscribe((response)=>{
           this.message = "Password Changed Successfully";
           this.passwordErrorMessage = "";
         },(error)=>{
           this.passwordErrorMessage = "Cannot Change password now";
           this.message = "";
         });
      }
      else{
        this.passwordErrorMessage = "Both password's doesn't match";
        this.message = "";
      }
  }

}
