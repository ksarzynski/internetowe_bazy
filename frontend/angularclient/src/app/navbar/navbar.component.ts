import { Component, OnInit } from '@angular/core';
import {environment} from "../../environments/environment";
import {Router} from "@angular/router";
import {CurrentUserService} from "../service/current-user.service";
import {AuthenticationService} from "../service/authentication/authentication.service";

@Component({
  selector: 'navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  username : string = 'niezalogowano';
  role: string = 'niezalogowano';

  constructor(private router : Router, private current_user : CurrentUserService, private authentication_service : AuthenticationService) {
    this.current_user.dataString$.subscribe(nazwa => this.username = nazwa);
    this.current_user.dataString2$.subscribe(value => this.role = value);
  }

  ngOnInit(): void {
    this.username = environment.userUsername;
    this.router.navigateByUrl('/', { skipLocationChange: true }).then(() => {
      this.router.navigate(['']);
    });
  }

  logout() {
    this.current_user.saveData("niezalogowano","niezalogowano");
    console.log("dziala");
    console.log(localStorage.getItem("token"));
    this.authentication_service.clearCache();
    environment.userID = null;
    environment.userUsername = "niezalogowano";
    environment.userRole = "";
  }
}
