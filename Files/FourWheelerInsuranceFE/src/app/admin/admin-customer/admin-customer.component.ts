import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserModel } from 'src/app/models/user.model';
import { AdminService } from 'src/app/services/admin.service';


@Component({
  selector: 'app-admin-customer',
  templateUrl: './admin-customer.component.html',
  styleUrls: ['./admin-customer.component.css']
})
export class AdminCustomerComponent implements OnInit {

  customers:UserModel[]|undefined;
  successMessage:string="";
  errorMessage:string="";
  isEmpty:boolean=false;
  constructor(private adminService:AdminService,private router:Router) { }


  ngOnInit(): void {

    if(sessionStorage.getItem("isAdminLoggedIn")==="true"){
      this.adminService.getAllCustomers().subscribe((response)=>{
        if(response.length === 0){
          this.isEmpty = true;
        }
        else{
        this.customers = response;
        this.isEmpty = false;
        }
      });
    }
    else{
      this.router.navigate(["/"]);
    } 
  }
  deleteCustomer(id:number){
    this.adminService.deleteCustomerById(id).subscribe((response)=>{
      this.ngOnInit();
      this.successMessage = "Customer Deleted Successfully";
    },()=>{
      this.ngOnInit();
      this.errorMessage = "Something Went Wrong Cannot Delete";
    })
  }

}
