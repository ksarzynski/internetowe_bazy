import { Component, OnInit } from '@angular/core';
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
  seatAvailable: boolean = true;
  cols: number[] = Array.from(Array(8).keys());
  rows: number[] = Array.from(Array(10).keys());
  constructor(private reservationService: ReservationService) { }

  ngOnInit(): void {
      this.reservationService.listSeats(this.hallId).subscribe(data => {
        this.seats = data;
        console.log(this.seats);
      })
  }

}
