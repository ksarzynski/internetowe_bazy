import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { seat } from 'src/app/model/seat/seat';

@Injectable({
  providedIn: 'root'
})
export class ReservationService {

  url = "https://localhost:443/halls/getSeats"
  constructor(private http: HttpClient) { 

  }

  listSeats(seanceId: number){
    return this.http.get<seat[]>(this.url, {params: {id: seanceId}});
  }
}
