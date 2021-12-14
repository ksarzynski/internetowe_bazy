import { Component, OnInit } from '@angular/core';
import {movie} from "../../model/movie/movie";
import {MovieServiceService} from "../../service/movie-service/movie-service.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-movie-page',
  templateUrl: './movie-page.component.html',
  styleUrls: ['./movie-page.component.css']
})
export class MoviePageComponent implements OnInit {

  id: number = 0;
  myMovie: movie = new movie();
  constructor(private movieService: MovieServiceService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.movieService.getMovie(this.id).subscribe(data => this.myMovie = data);
    this.route.queryParams.subscribe(params => {
      this.id = params['id'];
    })
  }

}
