import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { FeedBack } from "../models/feedBack.model";
import { ForgotPassword } from "../models/forgot-password.model";
import { Profile } from "../models/profile.model";
import { UserModel } from "../models/user.model";

@Injectable({
    providedIn:'root'
})
export class UserService
{
   
   constructor(private httpClient:HttpClient){}
   
   //used to get the Particular user based on ID;
   getUser():Observable<UserModel>{
     const customerId:number = Number(sessionStorage.getItem('customerId'));
     return this.httpClient.get<UserModel>(`http://localhost:8080/customers/${customerId}`);
   }

   //used to update the user profile like name, emailId, and phonenumber;
   updateUserProfile(updatedUser:UserModel):Observable<any>{
    return this.httpClient.post<any>("http://localhost:8080/customers/update",updatedUser);
   }

   //to sent the feedback from the user to backend;
   sentFeedBack(feedBack:FeedBack):Observable<any>{
     return this.httpClient.post<any>("http://localhost:8080/feed-back",feedBack);
   }
   sentProfile(profile:Profile):Observable<any>{
    console.log(profile);
    return this.httpClient.post<any>("http://localhost:8080/profile",profile);
  }

   validateEmail(emailId:string):Observable<any>{
     return this.httpClient.post<any>("http://localhost:8080/verify-customer-email",emailId);
   }

   resetPassword(forgotPasswordRequest:ForgotPassword):Observable<any>{
      return this.httpClient.post<any>("http://localhost:8080/reset-password",forgotPasswordRequest);
   }
}