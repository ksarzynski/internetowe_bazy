import {Component, EventEmitter, OnDestroy, OnInit, Output} from '@angular/core';
import {HttpErrorResponse, HttpResponse} from "@angular/common/http";
import {User} from "../model/user";
import {AuthenticationService} from "../service/authentication/authentication.service";
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import { RouterModule } from '@angular/router';
import {HeadersPrefix} from '../enum/headers.enum';
//import {NotificationsEnum} from '../enum/notifications.enum';
//import {NotificationsService} from '../service/notifications/notifications.service';
import {Subscription} from 'rxjs';
import {error} from "@angular/compiler/src/util";
import {environment} from "../../environments/environment";

@Component({
  selector: 'app-register-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})
export class LoginFormComponent implements OnInit {
  private subscriptions: Subscription[] = [];

  constructor(private authenticationService: AuthenticationService, private router: Router) {
  }

  @Output() loginEvent = new EventEmitter();

  ngOnInit() {
  }

  onLogin(user: User): void {
    console.log(user);
      this.authenticationService.loginUser(user).subscribe(
        (response: HttpResponse<any>) => {
          const token = response.body["token"];
          const user_id = response.body["userId"];
          const username = response.body["username"];
          environment.userUsername = username;
          environment.userID = user_id;
          console.log(username);
            this.authenticationService.saveToken(token || '{}');
            console.log(response.body["token"]);
            console.log(environment.userID);

            this.router.navigateByUrl("");
            window.confirm("Zalogowano użytkownika "+ username);
        },(error) => {
          window.confirm("Błędne dane logowania");
        }
      )
  }
}


