import { Component, OnInit } from '@angular/core';
import {User} from "../model/user";
import {Router} from "@angular/router";
import {AuthenticationService} from "../service/authentication/authentication.service";
import {HttpResponse} from "@angular/common/http";
import {environment} from "../../environments/environment";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  user: User = new User();

  constructor(private router: Router, private authService: AuthenticationService) { }

  ngOnInit(): void {
  }

  onSubmit() {
    this.authService.registerUser(this.user).subscribe((response: HttpResponse<any>) => {
      const username = response.body["username"];
      const email = response.body["email"];
      console.log(username);
      console.log(email);
      window.confirm("Zarejestrowano nowego użytkownika")
    },(error) => {
      console.log("Wystąpił błąd!")
    });
    this.router.navigateByUrl("login");
  }
}
