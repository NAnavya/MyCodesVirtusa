import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Profile } from 'src/app/models/profile.model';
import { AdminService } from 'src/app/services/admin.service';

@Component({
  selector: 'app-admin-profile',
  templateUrl: './admin-profile.component.html',
  styleUrls: ['./admin-profile.component.css']
})
export class AdminProfileComponent implements OnInit {

  profiles: Profile[] | undefined;
  successMessage: string = "";
  errorMessage: string = "";
  isEmpty: boolean = false;
  constructor(private adminService: AdminService, private router: Router) { }

  ngOnInit(): void {
    if (sessionStorage.getItem("isAdminLoggedIn") === "true") {
      this.adminService.getAllProfilesReceived().subscribe((response) => {
        if (response.length === 0) {
          this.isEmpty = true;
        }
        else {
          this.isEmpty = false;
          this.profiles = response;
        }

      });
    }
    else {
      this.router.navigate(["/"]);
    }
  }

}
