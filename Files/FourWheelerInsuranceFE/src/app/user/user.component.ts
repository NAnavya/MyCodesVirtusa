import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserModel } from '../models/user.model';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  user: UserModel | undefined;
  constructor(private userService: UserService, private router: Router) { }

  ngOnInit(): void {
    if (sessionStorage.getItem("isUserLoggedIn") === "true") {
      this.userService.getUser().subscribe(recievedUser=>{
        this.user = recievedUser;
      });
    }
    else{
      this.router.navigate(["/"]);
    }
  }

  //used to edit the profile of the user
  edit() {
    this.router.navigate(['/edit-user']);
  }

}
