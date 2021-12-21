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
  modalActor: actor = {} as actor;
  role = "";
  constructor(private actorService: ActorServiceService, private router: Router,
              private modalService: ModalService) {
    this.role = environment.userRole;
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

  openModal(id: string, actor: actor) {
    this.modalActor = actor;
    this.modalService.open(id);
  }

  isAdmin(){
    return this.role === 'admin';
  }
  
  confirmDelete(actor: actor){
    this.openModal('confirm-delete-actors', actor);
  }

  delete(id: number){
    this.actorService.deleteActor(id).subscribe();
    const currentUrl = this.router.url;
    this.router.navigateByUrl('/', {skipLocationChange: true}).then(() => {
      this.router.navigate([currentUrl]);
  });
  }
}
