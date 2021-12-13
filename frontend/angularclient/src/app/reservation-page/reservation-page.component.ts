import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs';
import { ReservationService } from '../service/reservation-service/reservation.service';

@Component({
  selector: 'app-reservation-page',
  templateUrl: './reservation-page.component.html',
  styleUrls: ['./reservation-page.component.css']
})
export class ReservationPageComponent implements OnInit {

  constructor(private route: ActivatedRoute, private reservationService: ReservationService) {
    this.rows = Array(9).fill(0).map((x,i)=>i);
    this.cols = Array(8).fill(0).map((x,i)=>i);
  }

  private sub: any
  private id: any;
  public rows: number[];
  public cols: number[];
  public col_count = 8;

  ngOnInit(): void {
    this.sub = this.route.params.subscribe(params => {
      this.id = params['id']; // (+) converts string 'id' to a number
      
      // In a real app: dispatch action to load the details here.
   });
  }

}
