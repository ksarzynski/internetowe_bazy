import { Component, OnInit } from '@angular/core';
import {cinema} from "../../model/cinema/cinema";
import {ActivatedRoute, Router} from "@angular/router";
import {CinemaServiceService} from "../../service/cinema-service/cinema-service.service";
import {environment} from "../../../environments/environment";
import { ModalService } from 'src/app/modal/_modal';
import { seance } from 'src/app/model/seance/seance';
import { getPrettyData } from 'src/app/utils/DateUtils';

@Component({
  selector: 'app-cinema-list',
  templateUrl: './cinema-list.component.html',
  styleUrls: ['./cinema-list.component.css']
})
export class CinemaListComponent implements OnInit {
  cinemas: cinema[] = []
  seances: seance[] = []

  constructor(private cinemaService: CinemaServiceService, private router: Router,
    private modalService: ModalService, private _activatedRoute : ActivatedRoute) {

  }

  ngOnInit(): void {
    this.getCinemas();

    this.modalService.add('seances');
    this.cinemas;
  }

  private getCinemas() {
    console.log(environment.userID);
    console.log("fetching cinemas");
    this.cinemaService.listCinemas().subscribe(data => {
      this.cinemas = data;
    });
  }

  goToHalls(id: string) {

  }

  goToSeances(id: string) {
    console.log("fetching seances and opening modal");
    this.cinemaService.listSeances(id).subscribe(data => {
      this.seances = data;
      data.forEach(seance => {
        seance.startDateString = getPrettyData(seance.startDate)
        seance.endDateString = getPrettyData(seance.endDate)
      })
      console.log(this.seances[1]);
    })

    this.modalService.open('seances');
  }



  closeModal(id: string){
    this.modalService.close(id);
  }

  reservation(id: number){
    console.log("reservation called: " + id);
    this.router.navigate(['reservation'], {queryParams: {seanceId: id}});
  }
}

