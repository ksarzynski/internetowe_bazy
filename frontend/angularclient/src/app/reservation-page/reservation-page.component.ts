import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { seat } from '../model/seat/seat';
import { ReservationService } from '../service/reservation/reservation.service';

@Component({
  selector: 'app-reservation-page',
  templateUrl: './reservation-page.component.html',
  styleUrls: ['./reservation-page.component.css']
})
export class ReservationPageComponent implements OnInit {
  hallId: number = 2;
  seats: seat[] = [];
  seatsTaken: seat[] = [];
  loaded = false;
  seanceId = 0;
  cols: number[] = Array.from(Array(8).keys());
  rows: number[] = Array.from(Array(10).keys());
  constructor(private reservationService: ReservationService, private route: ActivatedRoute) {
    
   }

  ngOnInit(): void {
      this.route.queryParams.subscribe(params => {
        this.seanceId = params['seanceId'];
        console.log(this.seanceId);
      })
      this.reservationService.listSeats(this.hallId).subscribe(data => {
        this.seats = data;
        console.log(this.seats);
      });
      this.reservationService.listReservedSeats(this.seanceId).subscribe(data =>{
        this.seatsTaken = data;
        this.loaded = true;
        console.log(this.seatsTaken);
      });
      
  }

  isSeatTaken(i:number, j:number){
    let foundSeats: seat[];
    foundSeats = this.seatsTaken.filter(s => s.myColumnNumber == j+1 && s.myRowNumber == i+1);
    return foundSeats.length > 0;
  }

}
