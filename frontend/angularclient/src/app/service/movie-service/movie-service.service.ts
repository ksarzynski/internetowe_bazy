import { Injectable } from '@angular/core';
import {HttpClient, HttpHandler, HttpRequest} from "@angular/common/http";
import {Observable} from "rxjs";
import {movie} from "../../model/movie/movie";

@Injectable({
  providedIn: 'root'
})
export class MovieServiceService {

  private url: string;
  constructor(private http: HttpClient) {
    this.url = 'https://localhost:443/movies/all_movies'
  }

  listMovies(): Observable<movie[]> {
    console.log(localStorage.getItem('token'));
    return this.http.get<movie[]>(this.url)
  }
}
