import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {seance} from "../../model/seance/seance";
import {movie} from "../../model/movie/movie";

@Injectable({
  providedIn: 'root'
})
export class SeanceServiceService {

  private url: string;
  constructor(private http: HttpClient) {
    this.url = 'https://localhost:443/seances/'
  }

  listSeances(): Observable<seance[]> {
    return this.http.get<seance[]>(this.url + 'getSeances')
  }

  async getSeancesMovies() : Promise<movie[] | undefined> {
    const seances = await this.getSeancesPromise();
    const movies : movie[] = [];
    if(seances !== undefined){
      seances.forEach(seance => {
        if(seance !== undefined){
          this.getSeanceMovie(seance.seance_id).then(
            value => {
              if(value !== undefined)
                movies.push(value)
            }
          );
        }
      })
    }
    return movies;
  }

  private async getSeancesPromise(): Promise<seance[] | undefined> {
    const response = this.http.get<seance[]>(this.url + 'getSeances');
    const result : seance[] = []
    await response.forEach(val => {
      val.forEach(seance => {
        result.push(seance)
      })
    })
    return result;
  }

  private async getSeanceMovie(seanceId: number): Promise<movie | undefined> {
    const result : movie[] = []
    const response = this.http.get<movie>(this.url + 'getSeanceMovie', {
      params: {
        id: seanceId
      }
    })
    await response.forEach(val => {
      result.push(val)
    })
    return result[0]
  }
}
