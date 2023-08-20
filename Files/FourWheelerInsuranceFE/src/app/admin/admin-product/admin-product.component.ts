import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Policy } from 'src/app/models/product.model';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-admin-product',
  templateUrl: './admin-product.component.html',
  styleUrls: ['./admin-product.component.css']
})
export class AdminProductComponent implements OnInit {

  products:Policy[]|undefined;
  noProductErrorMessage:string="";
  isEmpty:boolean = false;
  message:string="";

  constructor(private productService:ProductService,private router:Router) { }

  ngOnInit(): void {

    if(sessionStorage.getItem("isAdminLoggedIn") === "true"){
      this.productService.getPolicies().subscribe((productslist)=>{
        if(productslist.length === 0){
          this.isEmpty = true;
        }
        else{
          this.isEmpty = false;
        this.products = productslist;
        }
        this.message = "Policy Successfully updated";
      },(error)=>{
        this.noProductErrorMessage = "Something Went Wrong cannot get data";
      });
    }
    else{
      this.router.navigate(["/"]);
    }
   
  }

  editProduct(product:Policy){
    this.router.navigate(["/edit-product"],{state:{data:product}});
  }

  addProduct(){
    this.router.navigate(["/add-product"]);
  }
  
  deleteProduct(id:number){
    
    this.productService.deletePolicy(id).subscribe((response)=>{
      this.message = "Deleted Product Successfully";
    },(error)=>{
      this.message = "Something went wrong cannot delete product";
    })
  }

}
