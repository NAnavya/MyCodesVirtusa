import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FeedBack } from 'src/app/models/feedBack.model';
import { AdminService } from 'src/app/services/admin.service';

@Component({
  selector: 'app-admin-feedback',
  templateUrl: './admin-feedback.component.html',
  styleUrls: ['./admin-feedback.component.css']
})
export class AdminFeedbackComponent implements OnInit {

  feedBacks:FeedBack[]|undefined;
  successMessage:string="";
  errorMessage:string="";
  isEmpty:boolean = false;
  constructor(private adminService:AdminService,private router:Router) { }

  ngOnInit(): void {
    if(sessionStorage.getItem("isAdminLoggedIn")==="true")
    {
      this.adminService.getAllFeedBacksReceived().subscribe((response)=>{
        if(response.length === 0){
          this.isEmpty = true;
        }
        else{
          this.isEmpty = false;
          this.feedBacks = response;
        }
        
      });
    }
    else{
      this.router.navigate(["/"]);
    }
  }

}
