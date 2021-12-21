import {Component, OnInit, ViewChild} from '@angular/core';
import {MovieServiceService} from "../../service/movie-service/movie-service.service";
import {ModalService} from "../../modal/_modal";
import {Router} from "@angular/router";
import {movie} from "../../model/movie/movie";
import { environment } from 'src/environments/environment';
import {DirectorServiceService} from "../../service/director-service/director-service.service";


@Component({
  selector: 'app-movies-list',
  templateUrl: './movies-list.component.html',
  styleUrls: ['./movies-list.component.css']
})
export class MoviesListComponent implements OnInit {
  movies: movie[] = []
  modalMovie: movie = {} as movie
  role: string = "";
  constructor( private movieService: MovieServiceService,
               private router: Router,
               private modalService: ModalService,
               private directorService: DirectorServiceService){
    this.role = environment.userRole;
  }

  @ViewChild('myModal') myModal: any;

  ngOnInit(): void {
    this.getMovies();
  }

  private getMovies() {
    this.movieService.listMovies().subscribe(data => {
      this.movies = data;
      this.movies.forEach(
        movie => this.directorService.getMovieDirector(movie.movie_id).subscribe(
          director => movie.director = director.firstname + ' ' + director.surname
        )
      )
    });
  }

  closeModal(id: string) {
    this.modalService.close(id);
  }

  openModal(id: string, movie: movie) {
    this.modalMovie = movie;
    this.modalService.open(id);
  }

  isAdmin(){
    return this.role === 'admin';
  }

  editMovie(movie:movie){
    this.router.navigate(['/editMovie'], {queryParams: {movieId: movie.movie_id}});
  }


}
