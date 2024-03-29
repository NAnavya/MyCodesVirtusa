import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  name:string|undefined;
  constructor(private router:Router) { }

  ngOnInit(): void {
    this.name = sessionStorage.getItem("username");
  }
  
  logout(){
    sessionStorage.clear();
    this.router.navigate(["/"],{queryParams:{isLoggedOut:true}});
  }
}
