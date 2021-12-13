import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {environment} from "../../../environments/environment";
import {ModalService} from "../../modal/_modal";
import {actor} from "../../model/actor/actor";
import {ActorServiceService} from "../../service/actor-service/actor-service.service";

@Component({
  selector: 'app-actor-list',
  templateUrl: './actors-list.component.html',
  styleUrls: ['./actors-list.component.css']
})
export class ActorsListComponent implements OnInit {
  actors: actor[] = []

  constructor(private actorService: ActorServiceService, private router: Router,
              private modalService: ModalService) {
  }

  ngOnInit(): void {
    this.getActors();
  }

  private getActors() {
    console.log(environment.userID);
    this.actorService.listActors().subscribe(data => {
      this.actors = data;
    });
  }

  closeModal(id: string) {
    this.modalService.close(id);
  }

  openModal(id: string) {
    this.modalService.open(id);
  }
}