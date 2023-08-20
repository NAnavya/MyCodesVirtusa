import { Component, OnInit } from '@angular/core';
import { FormGroup,FormControl,Validators } from '@angular/forms'; '@angular/forms';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  loginForm = new FormGroup({
    User : new FormControl('',[Validators.required,Validators.email]),
    Password : new FormControl('',[Validators.required,Validators.pattern("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$")]),
  })

  login()
  {
    alert("form is woring");
    this.loginForm.reset();
  }

  get User(){
    return this.loginForm.get('User');
  }

  get Password(){
    return this.loginForm.get('Password');
  }
  
}
