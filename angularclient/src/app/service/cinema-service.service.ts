import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {cinema} from "../model/cinema/cinema";
import {User} from "../model/user";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class CinemaServiceService {
  private url: string;

  constructor(private http: HttpClient) {
    this.url = 'https://localhost:443/branches/cinemas';
  }

  listCinemas(): Observable<cinema[]> {
    return this.http.get<cinema[]>(this.url);
  }
}
