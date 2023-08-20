import { Component, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { UserModel } from 'src/app/models/user.model';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-edit-user',
  templateUrl: './edit-user.component.html',
  styleUrls: ['./edit-user.component.css']
})
export class EditUserComponent implements OnInit {

  user:UserModel;
  successMessage:string="";
  errorMessage:string="";
  constructor(private router:Router,private userService:UserService) { }

  ngOnInit(): void 
  {
    if(sessionStorage.getItem("isUserLoggedIn")==="true"){
      this.userService.getUser().subscribe(recievedUser=>{
        this.user = recievedUser;
      });
    }
    else{
      this.router.navigate(["/"]);
    }
  }

  //used to Udate the details of user;
  updateProfile(){
    this.userService.updateUserProfile(this.user).subscribe((response)=>{
      this.successMessage = "Details Updated Successfully";
    },(error)=>{
      this.errorMessage = "Something Went Wrong cannot update Details now";
    })
  }
}
