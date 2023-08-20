import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { FeedBack } from "../models/feedBack.model";


import { OrderDetails } from "../models/orderdetails.model";
import { Profile } from "../models/profile.model";
import { UserModel } from "../models/user.model";

@Injectable({
    providedIn:'root'
})
export class AdminService{
   

    constructor(private httpClient:HttpClient){}

    //to get all customers
    getAllCustomers():Observable<UserModel[]>{
        return this.httpClient.get<UserModel[]>("http://localhost:8080/customers");
    }

    //to delete the customer based on id
    deleteCustomerById(id:number):Observable<any>{
        return this.httpClient.delete<any>(`http://localhost:8080/customers/${id}`);
    }

    //to get all orders received from customers
    getAllOrdersReceived():Observable<OrderDetails[]>{
        return this.httpClient.get<OrderDetails[]>("http://localhost:8080/orders");
    }
  
    //to get all feedbacks given by customers
    getAllFeedBacksReceived():Observable<FeedBack[]>{
        return this.httpClient.get<FeedBack[]>("http://localhost:8080/allfeedBack");
    }
    getAllProfilesReceived():Observable<Profile[]>{
        return this.httpClient.get<Profile[]>("http://localhost:8080/allprofile");
    }
}