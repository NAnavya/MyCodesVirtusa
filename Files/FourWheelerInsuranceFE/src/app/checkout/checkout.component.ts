import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ProfileDetailsService } from '../services/profiledetails.service';

@Component({
  selector: 'app-checkout',
  templateUrl: './checkout.component.html',
  styleUrls: ['./checkout.component.css']
})
export class CheckoutComponent implements OnInit {


  checkOutForm:FormGroup;

  constructor(private profiledetails:ProfileDetailsService,private router:Router) { }

  ngOnInit(): void 
  {
    if(sessionStorage.getItem("isUserLoggedIn")==="true"){
      this.checkOutForm = new FormGroup({
        'aplyname': new FormControl('',Validators.required),
        'aplyaddress': new FormControl('',Validators.required),
        'aplyvehno': new FormControl('',Validators.required),
        'aplydate':new FormControl('',Validators.required),
        'aplyvehmodel':new FormControl('',Validators.required),
        'aplynumber':new FormControl('',[Validators.required,Validators.pattern('[0-9]{10}')])
      });
    }
    else{
      this.router.navigate(["/"]);
    }
  }

  //used to save the address entered by user;
  saveAddress(){
        this.profiledetails.policydetails = this.checkOutForm.value.aplyname + " "+  this.checkOutForm.value.aplyaddress +
        " "+ this.checkOutForm.value.aplyvehno+" "+ this.checkOutForm.value.aplyvehmodel+" "+ this.checkOutForm.value.aplynumber+" "+
        this.checkOutForm.value.aplydate;
      this.router.navigate(["/order-details"]);     
  }
}
