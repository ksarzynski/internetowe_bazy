import { Injectable } from '@angular/core';
import {User} from "../../model/user";
import {HttpClient, HttpResponse} from "@angular/common/http";
import {Observable} from "rxjs";
import {environment} from "../../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  private token: string;
  private loggedInUserEmail: string;
  private logoutsUrl: string;
  private host='https://localhost:443'
  constructor(private http: HttpClient) {
    this.logoutsUrl = `${this.host}/user/logout`;
    this.token = '';
    this.loggedInUserEmail = '';
  }
  public loginUser(user: User): Observable<HttpResponse<User>> {
    console.log("dziala 3");
    return this.http.post<User>(`https://localhost:443/authenticate`, user, { observe: 'response' });

  }
  // tslint:disable-next-line:typedef
  public clearCache() {
    console.log('Done');
    this.token = '';
    this.loggedInUserEmail = '';
    localStorage.removeItem('user');
    localStorage.removeItem('token');
    localStorage.removeItem('users');
  }

  public saveToken(token: string): void {
    this.token = token;
    localStorage.setItem('token', token);
  }

  public saveUser(user: User | null): void {
    localStorage.setItem('user', JSON.stringify(user));
  }

  public getUser(): User {
    return JSON.parse(localStorage.getItem('user')|| '{}');
  }

}
