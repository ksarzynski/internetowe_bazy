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
  hallId: number = 0;
  hallSize: number = 0;
  seats: seat[] = [];
  seatsTaken: seat[] = [];
  loaded = 0;
  seanceId = 0;
  cols: number[] = Array.from({length: 8}, (_, i) => i + 1);
  rows: number[] = Array.from({length: 10}, (_, i) => i + 1);
  max_col = 8;
  max_row = 0;
  seatsToReserve : number[] = [];

  constructor(private reservationService: ReservationService, private route: ActivatedRoute) {
    
   }

  ngOnInit(): void {
      this.loaded = 0;
      this.route.queryParams.subscribe(params => {
        this.seanceId = params['seanceId'];
        this.loaded += 1;
        console.log(this.seanceId);
      })
      this.reservationService.getSeanceHall(this.seanceId).subscribe(data =>{
        this.loaded += 1;
        this.hallId = data.cinema_hall_id;
        this.hallSize = data.size;
        this.max_row = this.hallSize / 8;
        this.rows = Array.from({length: this.max_row}, (_, i) => i + 1);
        
        this.reservationService.listSeats(this.hallId).subscribe(data => {
          this.seats = data;
          this.loaded += 1;
          console.log("seats:" + this.seats);
        });
      })
      
      this.reservationService.listReservedSeats(this.seanceId).subscribe(data =>{
        this.seatsTaken = data;
        //this.loaded = true;
        this.loaded += 1;
        console.log(this.seatsTaken);
      });
      
      
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

  isInList(i:number, j:number){
    return i*8 + j <= this.hallSize;
  }

  makeReservation(){
    //send post
    //TODO: change 99 to actual user id, change 1 to actual seance id
    this.reservationService.makeReservation(99, this.seatsToReserve, 1).subscribe(data =>{
      console.log("response: " + data);
    });
    //TODO: redirect 
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
