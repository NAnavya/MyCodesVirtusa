import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Request } from '../models/request.model';
import { AuthenticationService } from '../services/authentication.service';
import { ProductService } from '../services/product.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username: string = "";
  password: string = "";
  isLoggedOut:boolean=false;

  errorMessage: string = "";

  constructor(private router: Router, private activatedRoute:ActivatedRoute,private authService: AuthenticationService, private productService: ProductService) { }

  ngOnInit(): void 
  {
    this.activatedRoute.queryParams.subscribe((activerouter)=>{
      this.isLoggedOut = Boolean(activerouter.isLoggedOut);
    });
  }

  NavigateToSignup() {
    this.router.navigate(["/signup"]);
  }
  signin() {
    if (this.username !== null && this.password !== null) {
      const request: Request = {
        username: this.username,
        password: this.password
      }
      this.authService.authenticateSignin(request).subscribe((response) => {

        if(response["statusCode"] >= 400 && response["statusCode"] <=499)
        {
           this.errorMessage = response["errorMessage"]; 
        }
        else{
            sessionStorage.setItem('username',request.username);
			      sessionStorage.setItem('token', 'HTTP_TOKEN ' + response.token);
            sessionStorage.setItem('roles',response.roles);     
            sessionStorage.setItem('customerId',response.customerId);       


            if (sessionStorage.getItem("roles") === "ADMIN") 
            {
              sessionStorage.setItem("isAdminLoggedIn", "true");
              this.router.navigate(["admin"]);
            }
            else if (sessionStorage.getItem("roles") === "USER") {
              sessionStorage.setItem("isUserLoggedIn", "true");
              this.router.navigate(["home"]);
            }
          }
        },(error) => {
             this.errorMessage = "Something went wrong please login after sometime";
      });
    }
  }


}
