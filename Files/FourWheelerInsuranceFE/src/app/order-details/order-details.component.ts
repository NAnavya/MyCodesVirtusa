import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CartItems } from '../models/cartitems.model';
import { OrderDetails } from '../models/orderdetails.model';
import { CartService } from '../services/cart.service';
import { OrderService } from '../services/order.service';
import { ProfileDetailsService } from '../services/profiledetails.service';

@Component({
  selector: 'app-order-details',
  templateUrl: './order-details.component.html',
  styleUrls: ['./order-details.component.css']
})
export class OrderDetailsComponent implements OnInit {

  policydetails:string="";
  cartItems:CartItems[];
  totalPrice:number=0;
  orderItems:OrderDetails[] = [];
  successMessage: string;
  errorMessage: string;
  
  constructor(private router:Router,private address:ProfileDetailsService,
    private cartService:CartService,private orderService:OrderService) { }

  ngOnInit(): void {
    if(sessionStorage.getItem("isUserLoggedIn")==="true"){
      this.policydetails = this.address.policydetails;
      this.cartService.getCartProduct().subscribe((cartdata)=>{
        this.cartItems = cartdata;
        this.cartItems.forEach((cart)=>{
          const price = Number(cart["claimAmount"]);
          this.totalPrice = this.totalPrice + price;
        });
      });
    }
    else{
      this.router.navigate(["/"]);
    }
  }

  CheckOut(){
    this.router.navigate(["/checkout"]);
  }
  
  //used to place the order
  placeOrder(){
    this.cartItems.forEach((cartitem)=>{
      let orderDetails:OrderDetails = {
        customerid : cartitem.custid, 
        orderid:cartitem.id,
        policyName: cartitem.policyName,
        policyPrice : cartitem.policyPrice,
       claimAmount : cartitem.claimAmount,
       numberOfYearsPlan:cartitem.numberOfYearsPlan,
        policydetails:this.policydetails
      }
      console.log(this.policydetails);
      this.orderItems.push(orderDetails);
    });
    this.orderService.placeOrder(this.orderItems).subscribe((response)=>{
      this.successMessage = "Order Placed Successfully";
    },(error)=>{

      this.errorMessage="Cannot Place Order";
    }
    );
    this.router.navigate(["/thankyou"]);
  }

}
