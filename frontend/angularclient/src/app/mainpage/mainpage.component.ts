import {Component, OnInit, ViewChild} from '@angular/core';
import {Router} from "@angular/router";
import {ModalService} from "../modal/_modal";
import {seance} from "../model/seance/seance";
import {SeanceServiceService} from "../service/seance-service/seance-service.service";
import {movie} from "../model/movie/movie";
import {getPrettyData} from "../utils/DateUtils";
import {MovieServiceService} from "../service/movie-service/movie-service.service";
import { AuthenticationService} from "../service/authentication/authentication.service";

@Component({
  selector: 'app-mainpage',
  templateUrl: './mainpage.component.html',
  styleUrls: ['./mainpage.component.css']
})
export class MainpageComponent implements OnInit {

  seances: seance[] = []
  seancesMovies: movie[] = []
  modalMovie: movie = new movie();
  constructor( private seanceService: SeanceServiceService,
               private router: Router,
               private modalService: ModalService,
               private movieService: MovieServiceService){}

  @ViewChild('myModal') myModal: any;

  ngOnInit(): void {
    this.getSeances();
  }

  private getSeances() {
    this.seanceService.listSeances().subscribe(data => {
      data.forEach(seance => {
        seance.startDateString = getPrettyData(seance.startDate)
        seance.endDateString = getPrettyData(seance.endDate)
      })
      this.seances = data
      console.log(this.seances)
    })
  }

  closeModal(id: string) {
    this.modalService.close(id);
  }

  async openModal(id: string, name: string) {
    await this.getMovieByName(name);
    this.modalService.open(id);
  }

  async getMovie(id: number){
    await this.movieService.getMovie(id).subscribe(data => this.modalMovie = data)
  }

  async getMovieByName(name: string){
    await this.movieService.getMovieByName(name).subscribe(data => this.modalMovie = data)
  }
}
