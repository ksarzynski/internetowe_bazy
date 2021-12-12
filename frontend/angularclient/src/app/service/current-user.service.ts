import { Injectable } from '@angular/core';
import {BehaviorSubject} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class CurrentUserService {
  username: string = '';
  public usernameSubject = new BehaviorSubject<string>("");
  public dataString$ = this.usernameSubject.asObservable();

  public saveData(value: string){
    this.username = value;
    this.usernameSubject.next(this.username);
  }
  constructor() { }
}
