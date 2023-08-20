import { Component, OnInit } from '@angular/core';
import { Policy } from 'src/app/models/product.model';

import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  products:Policy[]|undefined;
  searchitem:any;

  constructor(private productService:ProductService) { }

  //getting data and initializing with products array.
  ngOnInit(): void {
    this.productService.getPolicies().subscribe(recievedProduct=>{
      this.products = recievedProduct;
    });
  }

}
