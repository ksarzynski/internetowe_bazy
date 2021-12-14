import { NgModule } from '@angular/core';
import {Router, RouterModule, Routes} from '@angular/router';
import {LoginFormComponent} from "./login-form/login-form.component";
import {UserFormComponent} from "./user-form/user-form.component";
import {RegisterComponent} from "./register/register.component";
import {MainpageComponent} from "./mainpage/mainpage.component";
import {CinemaListComponent} from "./list/cinema-list/cinema-list.component";
import {HallListComponent} from "./list/hall-list/hall-list.component";
import {SeancesListComponent} from "./list/seances-list/seances-list.component";
import {MoviesListComponent} from "./list/movies-list/movies-list.component";
import {DirectorsListComponent} from "./list/directors-list/directors-list.component";
import {ActorsListComponent} from "./list/actors-list/actors-list.component";
import {MoviePageComponent} from "./pages/movie-page/movie-page.component";

const routes: Routes = [
  {path: "login", component: LoginFormComponent},
  {path: "adduser", component: UserFormComponent},
  {path: 'cinemas', component: CinemaListComponent},
  {path: 'halls', component: HallListComponent},
  {path: 'seances', component: SeancesListComponent},
  {path: 'movies', component: MoviesListComponent},
  {path: 'register', component: RegisterComponent},
  {path: 'directors', component: DirectorsListComponent},
  {path: 'actors', component: ActorsListComponent},
  {path: 'movie', component: MoviePageComponent},
  { path: '', component: MainpageComponent},
  { path: '*', component: MainpageComponent}
];
@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ],
  declarations: []
})
export class AppRoutingModule {}


