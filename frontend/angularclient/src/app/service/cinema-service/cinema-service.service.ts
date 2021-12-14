import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {cinema} from "../../model/cinema/cinema";
import {Observable} from "rxjs";
import { seance } from 'src/app/model/seance/seance';

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

  listSeances(id: string): Observable<seance[]> {
    console.log("id in service: " + id);
    return this.http.get<seance[]>('https://localhost:443/branches/seances/'+id);
  }
}
