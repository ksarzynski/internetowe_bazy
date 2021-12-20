import { Injectable } from '@angular/core';
import {BehaviorSubject} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class CurrentUserService {
  username: string = '';
  role: string = '';
  public usernameSubject = new BehaviorSubject<string>("");
  public roleSubject = new BehaviorSubject<string>("");
  public dataString$ = this.usernameSubject.asObservable();
  public dataString2$ = this.roleSubject.asObservable();
  public saveData(value: string, roleVal: string){
    this.role = roleVal;
    this.username = value;
    this.usernameSubject.next(this.username);
    this.roleSubject.next(this.role);

  }
  constructor() { }
}
