import { Component, Input, OnInit } from '@angular/core';
import { CartItems } from 'src/app/models/cartitems.model';
import { Policy} from 'src/app/models/product.model';
import { CartService } from 'src/app/services/cart.service';

import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-product-item',
  templateUrl: './product-item.component.html',
  styleUrls: ['./product-item.component.css']
})
export class ProductItemComponent implements OnInit {

  @Input() product: Policy | undefined;
  constructor(private cartService: CartService) { }

  ngOnInit(): void {
  }
  addToCart() {
    let cartItem:CartItems = new CartItems(this.product,Number(sessionStorage.getItem("customerId")));
    this.cartService.addToCart(cartItem).subscribe({
      complete:()=>{alert("Added to Cart")},
  error:()=>{alert("Cannot Add Item to Cart")}
   });
  }
  //adding item to the cart and saving to database;
 
}
