import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { CustomValidators } from '../forms/CustomValidators';
import { ModalService } from '../modal/_modal';
import { actor } from '../model/actor/actor';
import { director } from '../model/director/director';
import { movie } from '../model/movie/movie';
import { ActorServiceService } from '../service/actor-service/actor-service.service';
import { DirectorServiceService } from '../service/director-service/director-service.service';
import { MovieServiceService } from '../service/movie-service/movie-service.service';

@Component({
  selector: 'app-movie-editor',
  templateUrl: './movie-editor.component.html',
  styleUrls: ['./movie-editor.component.css']
})
export class MovieEditorComponent implements OnInit {

  movie: movie = {} as movie;
  movieId: number = 0;
  allActors: actor[] = [];
  movieActors: actor[] = [];
  allDirectors: director[] = [];
  movieDirector: director = {} as director;

  constructor(private route:ActivatedRoute, private actorService:ActorServiceService, 
    private modalService: ModalService, private movieService: MovieServiceService,
    private directorService: DirectorServiceService) { }

  ngOnInit(): void {
    let loaded = false;
    this.route.queryParams.subscribe(params => {
      this.movieId = params['movieId'];
      console.log("movie id: " + this.movieId)
      loaded = true;
    })
    while(!loaded){

    }
    this.movieService.getMovie(this.movieId).subscribe(data => this.movie = data);

  }

  editActors(){
    this.actorService.listActors().subscribe(data => this.allActors = data);
    console.log("MOVIE ID: " + this.movie.movie_id)
    this.actorService.listActorsFromMovie(this.movie.movie_id).subscribe(data => {this.movieActors = data});
    this.modalService.open("actorsInMovie")
  }

  actorInMovie(actorToCheck: actor){
    return this.movieActors.map(data => data.actor_id).includes(actorToCheck.actor_id);
  }

  toggleActor(actorToToggle: actor, add:boolean){
    if(add){
      this.movieActors.push(actorToToggle);
    }
    else{
      this.movieActors = this.movieActors.filter(data => data.actor_id != actorToToggle.actor_id);
    }
    console.log("actors after toggle:" + this.movieActors);
  }

  closeModal(id: string){
    this.modalService.close(id);
  }

  editDirector(){
    this.directorService.listDirectors().subscribe(data => this.allDirectors = data);
    this.directorService.getMovieDirector(this.movieId).subscribe(data => this.movieDirector = data);
    this.modalService.open("directorsInMovie")
  }

  directorInMovie(directorToCheck: director){
      return directorToCheck.director_id == this.movieDirector.director_id;
  }


  toggleDirector(directorToToggle:director){
    this.movieDirector = directorToToggle;
  }

  editMovieData(){
    this.modalService.open("movieEditForm")
  }

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
    this.modalService.close("movieEditForm")
  }

  saveChanges(){
    
    this.movieService.updateActors(this.movie.movie_id, this.movieActors).subscribe();
    this.movieService.updateDirector(this.movie.movie_id, this.movieDirector.director_id).subscribe();
    this.movieService.updateData(this.movie).subscribe();

  }
}
