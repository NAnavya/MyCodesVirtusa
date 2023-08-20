import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { OrderDetails } from '../models/orderdetails.model';
import { OrderService } from '../services/order.service';

@Component({
  selector: 'app-myorders',
  templateUrl: './myorders.component.html',
  styleUrls: ['./myorders.component.css']
})
export class MyordersComponent implements OnInit {

  orders:OrderDetails[]|undefined;
  isPresent:boolean = false;
  constructor(private router:Router,private orderService:OrderService) { }

  ngOnInit(): void {
    if(sessionStorage.getItem("isUserLoggedIn")==="true"){
      const customerId =+ sessionStorage.getItem("customerId")
      this.orderService.getMyOrders(customerId).subscribe((response)=>{
        if(response.length > 0){
          this.orders = response;
          this.isPresent = true;
        }
        else{
          this.isPresent = false; 
        }
      },(error)=>{
        this.isPresent = false;
      });
    }
    else{
      this.router.navigate(["/"]);
    }
  }

}
