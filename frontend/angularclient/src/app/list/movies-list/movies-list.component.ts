import {Component, OnInit, ViewChild} from '@angular/core';
import {cinema} from "../../model/cinema/cinema";
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
  constructor( private movieService: MovieServiceService, private router: Router, private modalService: ModalService){

  }
  @ViewChild('myModal') myModal: any;

  ngOnInit(): void {
  this.getMovies();
  this.movies;
  }


  private getMovies() {
    this.movieService.listMovies().subscribe(data => {
      this.movies = data;
    });
  }
  closeModal(id: string) {
    this.modalService.close(id);
  }
  openModal(id: string) {
    this.modalService.open(id);
  }

}
