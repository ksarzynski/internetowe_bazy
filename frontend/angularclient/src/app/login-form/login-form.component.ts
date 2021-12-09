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
@Component({
  selector: 'app-login-form',
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
      this.authenticationService.loginUser(user).subscribe(
        (response: HttpResponse<User>) => {
          const token = response.headers.get(HeadersPrefix.JWT_TOKEN);
          this.authenticationService.saveToken(token || '{}');
          console.log(token);
          this.authenticationService.saveUser(response.body);
        }
      )
  }
}


