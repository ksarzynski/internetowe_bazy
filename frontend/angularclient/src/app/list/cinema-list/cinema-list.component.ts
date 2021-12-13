import { Component, OnInit } from '@angular/core';
import {cinema} from "../../model/cinema/cinema";
import {Router} from "@angular/router";
import {CinemaServiceService} from "../../service/cinema-service/cinema-service.service";
import {environment} from "../../../environments/environment";

@Component({
  selector: 'app-cinema-list',
  templateUrl: './cinema-list.component.html',
  styleUrls: ['./cinema-list.component.css']
})
export class CinemaListComponent implements OnInit {
  cinemas: cinema[] = []

  constructor(private cinemaService: CinemaServiceService, private router: Router) {
  }

  ngOnInit(): void {
    this.getCinemas();
    this.cinemas;
  }

  private getCinemas() {
    console.log(environment.userID);
    this.cinemaService.listCinemas().subscribe(data => {
      this.cinemas = data;
    });
  }

  goToHalls(id: string) {
  }

  goToSeances(id: string) {

  }
}

