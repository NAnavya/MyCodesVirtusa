import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { OrderDetails } from 'src/app/models/orderdetails.model';
import { AdminService } from 'src/app/services/admin.service';
import { OrderService } from 'src/app/services/order.service';

@Component({
  selector: 'app-order-recieved',
  templateUrl: './order-recieved.component.html',
  styleUrls: ['./order-recieved.component.css']
})
export class OrderRecievedComponent implements OnInit {

  ordersRecieved:OrderDetails[];
  isEmpty:boolean = false;
  message:string="";
  constructor(private adminService:AdminService,private orderService:OrderService,private router:Router) { }

  ngOnInit(): void {

    if(sessionStorage.getItem("isAdminLoggedIn")==="true"){
      this.adminService.getAllOrdersReceived().subscribe((orders)=>{
        if(orders.length === 0){
          this.isEmpty = true;
        }
        else{
          this.ordersRecieved = orders;
          this.isEmpty = false;
        }
      });
    }
    else{
      this.router.navigate(["/"]);
    }
      
  }
  deleteOrder(id:number){
    this.orderService.deleteOrder(id).subscribe((response)=>{
      this.message = "Deleted Product Successfully";
    },(error)=>{
      this.message = "Something went wrong cannot delete product";
    })
  }

 
}
