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
  cols: number[] = Array.from({length: 8}, (_, i) => i + 1);
  rows: number[] = Array.from({length: 10}, (_, i) => i + 1);
  seatsToReserve : number[] = [];

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
      this.reservationService.getSeanceHall(this.seanceId).subscribe(data =>{
        this.hallId = data.cinema_hall_id;
      })
      
  }

  isSeatTaken(i:number, j:number){
    let foundSeats: seat[];
    foundSeats = this.seatsTaken.filter(s => s.myColumnNumber == j && s.myRowNumber == i);
    return foundSeats.length > 0;
  }

  addToReservation(i:number, j:number){
    let foundSeat = this.seats.find(s => {
      return s.myColumnNumber == j && s.myRowNumber == i;
    });
    console.log(foundSeat);
    if(foundSeat == undefined || this.seatsTaken.includes(foundSeat))
      return;
    if(!this.seatsToReserve.includes(foundSeat.seat_id))
      this.seatsToReserve.push(foundSeat.seat_id);
    else
      this.seatsToReserve = this.seatsToReserve.filter(id => id !== foundSeat?.seat_id);
    console.log("current reservation: " + this.seatsToReserve);
  }

  makeReservation(){
    //send post
    //redirect 
  }


  isSeatClicked(i:number, j:number){
    let foundSeat = this.seats.find(s => {
      return s.myColumnNumber == j && s.myRowNumber == i;
    });
    if(foundSeat != undefined)
      return this.seatsToReserve.includes(foundSeat.seat_id);
    return false;
  }
}
