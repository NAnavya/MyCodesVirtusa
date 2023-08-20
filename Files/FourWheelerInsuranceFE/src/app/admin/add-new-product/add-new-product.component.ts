import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ProductItemComponent } from 'src/app/home/product-list/product-item/product-item.component';
import { Policy } from 'src/app/models/product.model';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-add-new-product',
  templateUrl: './add-new-product.component.html',
  styleUrls: ['./add-new-product.component.css']
})
export class AddNewProductComponent implements OnInit {

  addNewProductForm:FormGroup;
  successMessage:string="";
  errorMessage:string="";
  policy:Policy;
  constructor(private router:Router,private productService:ProductService) { }

  ngOnInit(): void {

    if(sessionStorage.getItem("isAdminLoggedIn")==="true"){
      this.addNewProductForm = new FormGroup({
        "policyName":new FormControl("",Validators.required),
        "policyPrice": new FormControl("",Validators.required),
        "numberOfYearsPlan": new FormControl("",Validators.required),
        "claimAmount":new FormControl("",Validators.required)
      });
    }
    else{
      this.router.navigate(["/"]);
    }

     
    }

  addProduct(){
    console.log(this.addNewProductForm.value);
    let policy:Policy = {
      // policyid:this.policy.policyid,
      policyName: this.addNewProductForm.value.policyName,
      policyPrice: this.addNewProductForm.value.policyPrice,
      numberOfYearsPlan: this.addNewProductForm.value.numberOfYearsPlan,
      claimAmount: this.addNewProductForm.value.claimAmount,
      
    }
      this.productService.addNewProduct(policy).subscribe({
        complete:()=>{alert("Policy Added Successfully")},
    error:()=>{alert("Policy  not Added Successfully")}
     });
    
  }

}

