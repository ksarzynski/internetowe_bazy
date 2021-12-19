import {Component, OnInit, ViewChild} from '@angular/core';
import {MovieServiceService} from "../../service/movie-service/movie-service.service";
import {ModalService} from "../../modal/_modal";
import {Router} from "@angular/router";
import {movie} from "../../model/movie/movie";


@Component({
  selector: 'app-movies-list',
  templateUrl: './movies-list.component.html',
  styleUrls: ['./movies-list.component.css']
})
export class MoviesListComponent implements OnInit {
  movies: movie[] = []
  modalMovie: movie = {} as movie

  constructor( private movieService: MovieServiceService, private router: Router, private modalService: ModalService){}

  @ViewChild('myModal') myModal: any;

  ngOnInit(): void {
    this.getMovies();
  }

  private getMovies() {
    this.movieService.listMovies().subscribe(data => {
      this.movies = data;
    });
  }

  closeModal(id: string) {
    this.modalService.close(id);
  }

  openModal(id: string, movie: movie) {
    this.modalMovie = movie;
    this.modalService.open(id);
  }

  logged_in(){
    return true;
  }

  editMovie(movie:movie){
    this.router.navigate(['/editMovie'], {queryParams: {movieId: movie.movie_id}});
  }
  
  
}
