import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormControl, FormGroup, ValidationErrors, ValidatorFn, Validators } from '@angular/forms';
import { actor } from 'src/app/model/actor/actor';
import { ActorServiceService } from 'src/app/service/actor-service/actor-service.service';
import { CustomValidators } from '../CustomValidators';

@Component({
  selector: 'app-actor-form',
  templateUrl: './actor-form.component.html',
  styleUrls: ['./actor-form.component.css']
})


export class ActorFormComponent implements OnInit {

  act: actor = new actor();

  actorForm = new FormGroup ({
    firstname: new FormControl('', [Validators.required, CustomValidators.specialCharsValidator()]),
    surname: new FormControl('', [Validators.required, CustomValidators.specialCharsValidator()]),
    description: new FormControl('', [Validators.required]),
    imageUrl: new FormControl('')
  });

  onSubmit(){
    this.actorService.addActor(this.act).subscribe(
      data => console.log(data)
    );
    //TODO: add actor to db
  }


  constructor(private actorService: ActorServiceService) { }

  ngOnInit(): void {
  }

}
