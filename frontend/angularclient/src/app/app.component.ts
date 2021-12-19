import { Component } from '@angular/core';
import {environment} from "../environments/environment";
import {Router} from "@angular/router";
import {AuthenticationService} from "./service/authentication/authentication.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  title: string;
  username: string;
  constructor(private router : Router, private auth : AuthenticationService) {
    this.title = 'Spring Boot - Angular Application';
    this.username = environment.userUsername;
    this.router.navigateByUrl("/movies");
  }
}
