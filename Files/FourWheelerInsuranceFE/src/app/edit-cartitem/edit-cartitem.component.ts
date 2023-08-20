import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CartItems } from 'src/app/models/cartitems.model';
import { CartService } from 'src/app/services/cart.service';

@Component({
  selector: 'app-edit-cartitem',
  templateUrl: './edit-cartitem.component.html',
  styleUrls: ['./edit-cartitem.component.css']
})
export class EditCartitemComponent implements OnInit {

  cartitem:CartItems|undefined;
  actualPrice:number=0;
  constructor(private cartService:CartService,private router:Router) { }

  ngOnInit(): void {
    if(sessionStorage.getItem("isUserLoggedIn")==="true"){
      this.cartitem=history.state.data;
      this.actualPrice = this.cartitem.policyPrice / this.cartitem.numberOfYearsPlan;
    }
    else{
      this.router.navigate(["/"]);
    }
   
  }

  updateQuantity(){ 
    this.cartitem.policyPrice = this.actualPrice * this.cartitem.numberOfYearsPlan;
    this.cartService.updateCartProduct(this.cartitem).subscribe(()=>{
      this.router.navigate(["/cart"]);
  });
  }

}
