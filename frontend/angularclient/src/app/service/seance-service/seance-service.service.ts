import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { seance } from 'src/app/model/seance/seance';
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class SeanceServiceService {

  private url: string;
  constructor(private http: HttpClient) {
    this.url = 'https://localhost:443/branches/seances/1'
  }

  listSeances(id: string): Observable<seance[]> {
    return this.http.get<seance[]>(this.url)
  }
}
