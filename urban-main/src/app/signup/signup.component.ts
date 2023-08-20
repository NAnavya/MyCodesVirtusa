import { Component, OnInit } from '@angular/core';
import {FormGroup,FormControl,Validators} from '@angular/forms'

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  signupForm = new FormGroup({
    Name : new FormControl('',[Validators.required,Validators.minLength(3),Validators.maxLength(15)]),
    User : new FormControl('',[Validators.required,Validators.email]),
    Number : new FormControl('',[Validators.required,Validators.pattern("[0-9]{10}")]),
    Password : new FormControl('',[Validators.required,Validators.pattern("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$")]),
    CuPassword : new FormControl('',[Validators.required,Validators.pattern("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$")]),
  })

  get Name(){
    return this.signupForm.get('Name');
  }

  get User(){
    return this.signupForm.get('User');
  }

  get Number(){
    return this.signupForm.get('Number');
  }

  get Password(){
    return this.signupForm.get('Password');
  }

  get CuPassword(){
    return this.signupForm.get('CuPassword');
  }

  signup()
  {
    alert("Signup Successful");
    this.signupForm.reset();
  }

}
