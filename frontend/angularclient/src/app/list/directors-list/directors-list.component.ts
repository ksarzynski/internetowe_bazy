import { Component, OnInit } from '@angular/core';
import {director} from "../../model/director/director";
import {Router} from "@angular/router";
import {DirectorServiceService} from "../../service/director-service/director-service.service";
import {environment} from "../../../environments/environment";
import {ModalService} from "../../modal/_modal";

@Component({
  selector: 'app-director-list',
  templateUrl: './directors-list.component.html',
  styleUrls: ['./directors-list.component.css']
})
export class DirectorsListComponent implements OnInit {
  directors: director[] = []
  modalDirector: director = <director>{};

  constructor(private directorService: DirectorServiceService, private router: Router,
              private modalService: ModalService) {
  }

  ngOnInit(): void {
    this.getDirectors();
  }

  private getDirectors() {
    console.log(environment.userID);
    this.directorService.listDirectors().subscribe(data => {
      this.directors = data;
    });
  }

  closeModal(id: string) {
    this.modalService.close(id);
  }

  openModal(id: string, dir: director) {
    this.modalDirector = dir;
    this.modalService.open(id);
  }
}
