import {Component, OnInit, ViewChild} from '@angular/core';
import {MovieServiceService} from "../../service/movie-service/movie-service.service";
import {ModalService} from "../../modal/_modal";
import {Router} from "@angular/router";
import {movie} from "../../model/movie/movie";
import { environment } from 'src/environments/environment';
import {DirectorServiceService} from "../../service/director-service/director-service.service";
import {review} from "../../model/review/review";
import {ReviewServiceService} from "../../service/review-service/review-service.service";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {CustomValidators} from "../../forms/CustomValidators";


@Component({
  selector: 'app-movies-list',
  templateUrl: './movies-list.component.html',
  styleUrls: ['./movies-list.component.css']
})
export class MoviesListComponent implements OnInit {
  movies: movie[] = []
  reviews: review[][] = []
  review: review =  {} as review
  movieReviews: review[] = []
  modalMovie: movie = {} as movie
  role: string = "";
  constructor( private movieService: MovieServiceService,
               private router: Router,
               private modalService: ModalService,
               private directorService: DirectorServiceService,
               private reviewService: ReviewServiceService){
    this.role = environment.userRole;
  }

  @ViewChild('myModal') myModal: any;

  ngOnInit(): void {
    this.getMovies();
  }

  private getMovies() {
    this.movieService.listMovies().subscribe(data => {
      this.movies = data;
      this.movies.forEach(movie => {
        this.directorService.getMovieDirector(movie.movie_id).subscribe(
          director => movie.director = director.firstname + ' ' + director.surname
        )
        this.reviewService.getMovieReviews(movie.movie_id).subscribe(
          reviewList => this.reviews.push(reviewList)
        )
      })
    });
  }

  closeModal(id: string) {
    this.modalService.close(id);
  }

  openModal(id: string, movie: movie) {
    this.modalMovie = movie;
    this.modalService.open(id);
    this.movieReviews = this.reviews[this.movies.indexOf(movie)]
  }

  isAdmin(){
    return this.role === 'admin';
  }

  editMovie(movie:movie){
    this.router.navigate(['/editMovie'], {queryParams: {movieId: movie.movie_id}});
  }

  reviewForm = new FormGroup ({
    description: new FormControl('', [Validators.required, CustomValidators.specialCharsValidator()]),
    value: new FormControl('', [Validators.required, CustomValidators.numberValidator()]),
  });

  onSubmit(movie_id: number){
    this.reviewService.addReview(this.review, movie_id).subscribe(
      data => console.log(data)
    );
  }
}
