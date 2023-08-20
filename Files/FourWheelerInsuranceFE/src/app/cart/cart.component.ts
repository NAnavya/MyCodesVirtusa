import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CartItems } from '../models/cartitems.model';
import { Policy } from '../models/product.model';
import { CartService } from '../services/cart.service';


@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  cartproducts:CartItems[]|undefined; 
  totalPrice:number=0;
  cartlen:number=0;
  errorMessage:string  = "";

  constructor(private cartService:CartService,private router:Router) {}
  ngOnInit(): void 
  {
  if(sessionStorage.getItem("isUserLoggedIn")==="true"){
    this.cartService.getCartProduct().subscribe(response=>{

      if(response["statusCode"] >=400 && response["statusCode"] <=499)
      {
        console.log("if condition of cart");
        this.errorMessage = response["errorMessage"];
        this.cartlen = 0;  
      }
      
      else{
        this.cartproducts = response;
        this.cartlen = this.cartproducts.length;
         this.cartproducts.forEach((cartitems)=>{
          const price = Number(cartitems["claimAmount"]);
          this.totalPrice = this.totalPrice +price;
          console.log(this.totalPrice);
        });
      }
   });
  }
  else{
    this.router.navigate(["/"]);
  }
  }

  navigateCheckout(){
    this.router.navigate(["/checkout"]);
  }

  productDeleteFromCart(id:number){
      this.cartService.deleteFromCart(id).subscribe((response)=>{
        this.ngOnInit();
      })
  }
  editCartItem(cartitem:CartItems){
    this.router.navigate(['/edit-cart'],{state:{data:cartitem}});
  }

}
