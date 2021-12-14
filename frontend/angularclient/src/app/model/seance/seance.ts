import { movie } from "../movie/movie";
import { hall } from '../hall/hall';

export class seance {
  seance_id: number;
  startDate: Date | undefined;
  endDate: Date | undefined;
  nameFilm: string;
  price: number;
  noAvailableSeats: number;
  movie: movie;
  cinemaHall: hall 

  constructor() {
    this.seance_id = 0;
    this.nameFilm = '';
    this.price = 0;
    this.noAvailableSeats = 0;
    this.movie = new movie();
    this.cinemaHall = new hall();
  }
}


