import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Router } from "@angular/router";
import { Observable } from "rxjs";
import { CartItems } from "../models/cartitems.model";


@Injectable({
    providedIn:'root'
})
export class CartService{

    customerId = sessionStorage.getItem("customerId");
    constructor(private router:Router,private httpClient:HttpClient){}

    //used to add item in the cart.
    addToCart(cartItem:CartItems):Observable<any>{
        return this.httpClient.post<any>("http://localhost:8080/cart",cartItem);
    }

    //get data from cart based on customerid
    getCartProduct():Observable<CartItems[]>{
        return this.httpClient.get<CartItems[]>(`http://localhost:8080/cart/${this.customerId}`);
    }

    //update the data present in the cart.
    updateCartProduct(cartItem:CartItems):Observable<any>{
        return this.httpClient.post<any>(`http://localhost:8080/cart/update/${this.customerId}`,cartItem);
    }

    //delete from cart.
    deleteFromCart(id:number):Observable<any>{
       return this.httpClient.delete<any>(`http://localhost:8080/cart/delete/${id}`);
    }
}