import { Component, OnInit } from '@angular/core';
import {HttpErrorResponse, HttpResponse} from "@angular/common/http";
import {User} from "../model/user";
import {AuthenticationService} from "../service/authentication.service";
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import { RouterModule } from '@angular/router';
import {Subscription} from 'rxjs';
@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})
export class LoginFormComponent implements OnInit {

  constructor(private authenticationService: AuthenticationService, private router: Router) { }

  ngOnInit() {
  }

  onLogin(user: User): void {
      this.authenticationService.login(user).subscribe();
  }
}
