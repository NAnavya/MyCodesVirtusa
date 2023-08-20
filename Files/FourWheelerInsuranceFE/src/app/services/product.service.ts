import { HttpClient } from "@angular/common/http";
import { EventEmitter, Injectable, OnInit } from "@angular/core";
import { Observable } from "rxjs";
import { Policy } from "../models/product.model";

@Injectable({
    providedIn:'root'
})
export class ProductService{
    popup(){
      throw new Error('Method not implemented.');
    }
    
    constructor(private httpClient:HttpClient){}
 
    getPolicies():Observable<Policy[]>{
        return this.httpClient.get<Policy[]>("http://localhost:8080/policies");
    }

    addNewProduct(policy:Policy):Observable<any>{
        return this.httpClient.post<any>("http://localhost:8080/admin/insertPolicy",policy);
    }

    updatePolicy(policy:Policy):Observable<any>{
        return this.httpClient.post<any>("http://localhost:8080/admin/updatePolicy",policy);
    }

    deletePolicy(id:number):Observable<any>{
        return this.httpClient.delete<any>(`http://localhost:8080/delete-policy/${id}`);
    }
}