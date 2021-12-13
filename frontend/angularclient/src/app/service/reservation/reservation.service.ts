import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { seat } from 'src/app/model/seat/seat';

@Injectable({
  providedIn: 'root'
})
export class ReservationService {

  url = "https://localhost:443/halls/getSeats"
  url2 = "https://localhost:443/reservations/seatsForSeance"
  constructor(private http: HttpClient) { 

  }

  listSeats(seanceId: number){
    return this.http.get<seat[]>(this.url, {params: {id: seanceId}});
  }

  listReservedSeats(seanceId: number){
    return this.http.get<seat[]>(this.url2, {params: {seanceId: seanceId}});
  }
}
