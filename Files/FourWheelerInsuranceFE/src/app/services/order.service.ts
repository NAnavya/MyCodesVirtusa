import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { OrderDetails } from "../models/orderdetails.model";

@Injectable({
    providedIn:"root"
})
export class OrderService{
    constructor(private httpClient:HttpClient){}

    //used to place the order for customers.
    placeOrder(orderDetails:OrderDetails[]):Observable<any>{
        return this.httpClient.post<any>("http://localhost:8080/order",orderDetails);
    }

    //used to get the particular customer order based on CustomerId.
    getMyOrders(id:number):Observable<OrderDetails[]>{
        return this.httpClient.get<OrderDetails[]>(`http://localhost:8080/myOrders/ ${id}`);
    }
    deleteOrder(id:number):Observable<any>{
        return this.httpClient.delete<any>(`http://localhost:8080/delete-order/${id}`);
    }
}