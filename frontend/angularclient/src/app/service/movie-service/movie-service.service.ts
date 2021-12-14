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
    this.url = 'https://localhost:443/movies/'
  }

  listMovies(): Observable<movie[]> {
    return this.http.get<movie[]>(this.url + 'getMovies')
  }

  getMovie(id: number) : Observable<movie> {
    return this.http.get<movie>(this.url + 'getMovie', {
      params: {
        id: id
      }
    })
  }

  getMovieByName(name: string) : Observable<movie> {
    return this.http.get<movie>(this.url + 'getMovieByName', {
      params: {
        name: name
      }
    })
  }
}
