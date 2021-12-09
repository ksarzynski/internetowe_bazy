export class movie{
  movie_id : number;
  name : string;
  category : string;
  duration : number;
  director : string;
  description : string;
  pg : number;
  rating : number;
  basePrice: number;
  constructor() {
    this.movie_id = 0;
    this.name= '';
    this.category= '';
    this.duration= 0;
    this.director = '';
    this.description = '';
    this.pg = 0;
    this.rating = 0;
    this.basePrice = 0;
  }
}
