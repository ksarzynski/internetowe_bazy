import { Component, OnInit } from '@angular/core';
import { AuthenticationService} from "../service/authentication/authentication.service";

@Component({
  selector: 'app-mainpage',
  templateUrl: './mainpage.component.html',
  styleUrls: ['./mainpage.component.css']
})
export class MainpageComponent implements OnInit {

  constructor(private auth : AuthenticationService) { }

  ngOnInit(): void {

  }

}
