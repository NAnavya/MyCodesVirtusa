import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { FeedBack } from '../models/feedBack.model';


import { UserService } from '../services/user.service';

@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.css']
})
export class ContactComponent implements OnInit {

  feedBackForm:FormGroup;
  successMessage:string;
  errorMessage:string;

  constructor(private router:Router,private userService:UserService) { }

  ngOnInit(): void {
    if(sessionStorage.getItem("isUserLoggedIn")!=="true"){
      this.router.navigate(["/"]);
    }
    else{
      this.feedBackForm = new FormGroup({
        "Name" : new FormControl("",Validators.required),
        "emailId": new FormControl("",[Validators.required,Validators.pattern("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$")]),
        "PhoneNumber": new FormControl("",[Validators.required,Validators.pattern("^[0-9]{10}$")]),
        "feedback":new FormControl("",Validators.required)
      });
    }
  }

  //creating feedback model object and sending to backend;
  sentFeedBack(){
    let feedBackData : FeedBack = {
        customerId : Number(sessionStorage.getItem("customerId")),
        name : this.feedBackForm.value.Name,
        emailId:this.feedBackForm.value.emailId,
        phoneNumber : this.feedBackForm.value.PhoneNumber,
        feedBackgiven : this.feedBackForm.value.feedback
    }
    this.userService.sentFeedBack(feedBackData).subscribe((response)=>{
      this.successMessage = "FeedBack Updated Successfully";
    },(error)=>{ 
      this.errorMessage = "Something went Wrong cannot submit FeedBack"; 
    });
  }
}
