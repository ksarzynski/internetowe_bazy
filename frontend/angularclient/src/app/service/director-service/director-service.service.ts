import { Injectable } from '@angular/core';
import {HttpClient, HttpHandler, HttpRequest} from "@angular/common/http";
import {Observable} from "rxjs";
import {director} from "../../model/director/director";

@Injectable({
  providedIn: 'root'
})
export class DirectorServiceService {

  private url: string;
  constructor(private http: HttpClient) {
    this.url = 'https://localhost:443/directors'
  }

  listDirectors(): Observable<director[]> {
    return this.http.get<director[]>(this.url + '/getDirectors')
  }

  getDirector(): Observable<director> {
    return this.http.get<director>(this.url + '/getDirector', {params: {name: 'aa', surname: 'bb'}});
  }

  addDirector(director: director){
    return this.http.post<string>(this.url + '/addDirector', director);
  }

  getMovieDirector(movieId: number){
    return this.http.get<director>(this.url + '/getMovieDirector', {params: {movieId: movieId}});
  }

  deleteDirector(id: number){
    return this.http.delete<string>(this.url + '/deleteDirector', {params: {id: id}});
  }
}
