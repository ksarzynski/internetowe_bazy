import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { hall } from 'src/app/model/hall/hall';
import { seat } from 'src/app/model/seat/seat';

@Injectable({
  providedIn: 'root'
})
export class ReservationService {

  url = "https://localhost:443/halls/getSeats"
  url2 = "https://localhost:443/reservations/seatsForSeance"
  url3 = "https://localhost:443/seances/getHall"
  constructor(private http: HttpClient) { 

  }

  listSeats(seanceId: number){
    return this.http.get<seat[]>(this.url, {params: {id: seanceId}});
  }

  listReservedSeats(seanceId: number){
    return this.http.get<seat[]>(this.url2, {params: {seanceId: seanceId}});
  }

  getSeanceHall(seanceId: number){
    return this.http.get<hall>(this.url3, {params: {seanceId: seanceId}});  
  }
}
