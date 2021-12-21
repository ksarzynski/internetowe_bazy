import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {review} from "../../model/review/review";

@Injectable({
  providedIn: 'root'
})
export class ReviewServiceService {

  private url: string;

  constructor(private http: HttpClient) {
    this.url = 'https://localhost:443/reviews/'
  }

  addReview(review: review, movie_id: number){
    return this.http.post<string>(this.url + 'addReview', review, {
      params: {
        movieId: movie_id
      }
    });
  }

  getMovieReviews(movie_id: number): Observable<review[]> {
    return this.http.get<review[]>(this.url + 'getMovieReviews', {
      params: {
        movieId: movie_id
      }
    })
  }
}
