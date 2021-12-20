import { Injectable } from '@angular/core';
import {HttpClient, HttpHandler, HttpRequest} from "@angular/common/http";
import {Observable} from "rxjs";
import {movie} from "../../model/movie/movie";
import { actor } from 'src/app/model/actor/actor';

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

  addMovie(movie: movie) {
    return this.http.post(this.url + 'addMovie', movie);
  }

  updateActors(movieId: number, actors: actor[]){
    return this.http.post(this.url + 'updateActors', actors, {params: {movieId: movieId}});
  }

  updateDirector(movieId: number, directorId: number){
    return this.http.post(this.url + 'updateDirector', directorId, {params: {movieId: movieId}});
  }

  updateData(movie:movie){
    return this.http.post(this.url + 'updateData', movie);
  }

  
}
