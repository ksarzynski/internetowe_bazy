import { Injectable } from '@angular/core';
import {HttpClient, HttpHandler, HttpRequest} from "@angular/common/http";
import {Observable} from "rxjs";
import {movie} from "../../model/movie/movie";
import {AuthInterceptor} from "../authentication/authInterceptor";

@Injectable({
  providedIn: 'root'
})
export class MovieServiceService {

  private url: string;
  constructor(private http: HttpClient) {
    this.url = 'https://localhost:443/movies/all_movies'
  }

  listMovies(): Observable<movie[]> {
    return this.http.get<movie[]>(this.url)
  }
}
