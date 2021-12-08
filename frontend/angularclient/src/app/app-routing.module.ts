import { NgModule } from '@angular/core';
import {Router, RouterModule, Routes} from '@angular/router';
import {LoginFormComponent} from "./login-form/login-form.component";
import {UserFormComponent} from "./user-form/user-form.component";
import {LoginComponent} from "./login/login.component";
import {MainpageComponent} from "./mainpage/mainpage.component";
import {CinemaListComponent} from "./list/cinema-list/cinema-list.component";
import {HallListComponent} from "./list/hall-list/hall-list.component";
import {SeancesListComponent} from "./list/seances-list/seances-list.component";

const routes: Routes = [
  {path: "login", component: LoginComponent},
  {path: "adduser", component: UserFormComponent},
  { path: '', component: MainpageComponent},
  { path: '*', component: MainpageComponent},
  {path: 'cinemas', component: CinemaListComponent},
  {path: 'halls', component: HallListComponent},
  {path: 'seances', component: SeancesListComponent}
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


