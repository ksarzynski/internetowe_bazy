import { Component } from '@angular/core';
import {environment} from "../environments/environment";
import {Router} from "@angular/router";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  title: string;
  username: string;
  constructor(private router : Router) {
    this.title = 'Spring Boot - Angular Application';
    this.username = environment.userUsername;
    this.router.navigateByUrl("/movies");
  }
}
