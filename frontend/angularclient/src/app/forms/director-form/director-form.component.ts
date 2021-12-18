import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { director } from 'src/app/model/director/director';
import { CustomValidators } from '../CustomValidators';

@Component({
  selector: 'app-director-form',
  templateUrl: './director-form.component.html',
  styleUrls: ['./director-form.component.css']
})
export class DirectorFormComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  dir: director = new director();

  directorForm = new FormGroup ({
    firstname: new FormControl('', [Validators.required, CustomValidators.specialCharsValidator()]),
    surname: new FormControl('', [Validators.required, CustomValidators.specialCharsValidator()]),
    description: new FormControl('', [Validators.required, CustomValidators.specialCharsValidator()]),
    imageUrl: new FormControl('')
  });

  onSubmit(){
    console.log(this.directorForm.value)
    console.log(this.dir);
    //TODO: add dir to db
  }

}
