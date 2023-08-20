import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Policy } from 'src/app/models/product.model';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-admin-edit-product',
  templateUrl: './admin-edit-product.component.html',
  styleUrls: ['./admin-edit-product.component.css']
})
export class AdminEditProductComponent implements OnInit {

  productForm:FormGroup;
  product:Policy|undefined;

  successMessage:string;
  errorMessage:string;

  constructor(private productService:ProductService,private router:Router) { }

  ngOnInit(): void {


    if(sessionStorage.getItem("isAdminLoggedIn") === "true"){
      this.product = history.state.data;
      this.productForm = new FormGroup({
        "policyName": new FormControl(this.product.policyName,Validators.required),
        "policyPrice" : new FormControl(this.product.policyPrice,Validators.required),
        "claimAmount":new FormControl(this.product.claimAmount,Validators.required),
        "numberOfYearsPlan":new FormControl(this.product.numberOfYearsPlan,Validators.required)
      });
    }
    else{
      this.router.navigate(["/"]);
    }   
  }

  updatePolicy(){
    let product:Policy={
      id: this.product.id,
      policyName : this.productForm.value.policyName,
      policyPrice : this.productForm.value.policyPrice,
     numberOfYearsPlan:this.productForm.value.numberOfYearsPlan,
      claimAmount : this.productForm.value.claimAmount
    }
    this.productService.updatePolicy(product).subscribe({
      complete:()=>{alert("Policy Updated Successfully")},
      error:()=>{alert("Policy  not Updated Successfully")}
       });
      
    
  }

}
