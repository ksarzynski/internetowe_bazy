import { Injectable } from '@angular/core';
import {NotificationsEnum} from '../../enum/notifications.enum';
import {NotifierService} from 'angular-notifier';
import {LoginFormComponent} from "../../forms/login-form/login-form.component";

@Injectable({
  providedIn: 'root'
})
export class NotificationsService {
  constructor(private notifier: NotifierService) { }

  // tslint:disable-next-line:typedef
  public showMessage(type: NotificationsEnum, message: string) {
    this.notifier.notify(type, message);
  }

}
