import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormControl, FormGroup, ValidationErrors, ValidatorFn, Validators } from '@angular/forms';
import { actor } from 'src/app/model/actor/actor';
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
    description: new FormControl('', [Validators.required, CustomValidators.specialCharsValidator()]),
    imageUrl: new FormControl('')
  });

  onSubmit(){
    console.log(this.actorForm.value)
    console.log(this.act);
    //TODO: add actor to db
  }


  constructor() { }

  ngOnInit(): void {
  }

}
