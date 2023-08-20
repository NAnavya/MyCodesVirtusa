import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { map, Observable } from "rxjs";
import { Customer } from "../models/customer.model";
import { Request } from "../models/request.model";

@Injectable({
    providedIn:'root'
})
export class AuthenticationService{

    //base url of the rest api
    baseUrl:string = "http://localhost:8080";

    constructor(private httpClient:HttpClient){}

    //to authenticate the user who is logging in
    authenticateSignin(request:Request):Observable<any>
    {
        return this.httpClient.post<any>(this.baseUrl+"/signin", request, {headers: new HttpHeaders({ 'Content-Type': 'application/json'})});
       
    }

    //to save the new user data in the backend database.
    registerUser(customer:Customer):Observable<any>
    {
        return this.httpClient.post<any>(this.baseUrl+"/signup",customer,{headers: new HttpHeaders({ 'Content-Type': 'application/json' })});
    }
}