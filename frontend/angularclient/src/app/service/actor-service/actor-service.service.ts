import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {actor} from "../../model/actor/actor";

@Injectable({
  providedIn: 'root'
})
export class ActorServiceService {

  private url: string;
  constructor(private http: HttpClient) {
    this.url = 'https://localhost:443/actors'
  }

  listActors(): Observable<actor[]> {
    return this.http.get<actor[]>(this.url + '/getActors')
  }

  addActor(actor: actor){
    return this.http.post<string>(this.url + '/addActor', actor);
  }
}
