import { Injectable } from '@angular/core';
import {User} from "../model/user";
import {HttpClient, HttpResponse} from "@angular/common/http";
import {Observable} from "rxjs";
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor(private http: HttpClient){
  }

  public login(user: User): Observable<HttpResponse<User>> {
    return this.http.post<User>(`/authenticate`, user, { observe: 'response' });
  }

}
