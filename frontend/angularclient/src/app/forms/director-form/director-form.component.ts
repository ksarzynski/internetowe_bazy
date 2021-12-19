import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { director } from 'src/app/model/director/director';
import { DirectorServiceService } from 'src/app/service/director-service/director-service.service';
import { CustomValidators } from '../CustomValidators';

@Component({
  selector: 'app-director-form',
  templateUrl: './director-form.component.html',
  styleUrls: ['./director-form.component.css']
})
export class DirectorFormComponent implements OnInit {

  constructor(private directorService: DirectorServiceService) { }

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
    this.directorService.addDirector(this.dir).subscribe(data => console.log(data));
  }

}
