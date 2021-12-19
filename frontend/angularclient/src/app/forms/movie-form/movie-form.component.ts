import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { movie } from 'src/app/model/movie/movie';
import { MovieServiceService } from 'src/app/service/movie-service/movie-service.service';
import { CustomValidators } from '../CustomValidators';

@Component({
  selector: 'app-movie-form',
  templateUrl: './movie-form.component.html',
  styleUrls: ['./movie-form.component.css']
})
export class MovieFormComponent implements OnInit {

  constructor(private movieService: MovieServiceService) { }

  ngOnInit(): void {
  }

  movie: movie = new movie();

  movieForm = new FormGroup ({
    name: new FormControl('', [Validators.required]),
    category: new FormControl('', [Validators.required, CustomValidators.specialCharsValidator()]),
    description: new FormControl('', [Validators.required, CustomValidators.specialCharsValidator()]),
    duration : new FormControl('', [Validators.required, CustomValidators.numberValidator()]),
    pg : new FormControl('', [Validators.required]),
    rating : new FormControl('', [Validators.required]),
    basePrice: new FormControl('', [Validators.required, CustomValidators.numberValidator()]),
    
    imageUrl: new FormControl('')
  });

  onSubmit(){
    //console.log(this.movie);
    this.movieService.addMovie(this.movie).subscribe(data => console.log(data));
  }

}
