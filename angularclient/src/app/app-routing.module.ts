import { NgModule } from '@angular/core';
import {Router, RouterModule, Routes} from '@angular/router';
import {LoginFormComponent} from "./login-form/login-form.component";
import {UserFormComponent} from "./user-form/user-form.component";
import {LoginComponent} from "./login/login.component";
import {MainpageComponent} from "./mainpage/mainpage.component";
import {CinemaListComponent} from "./cinema-list/cinema-list.component";

const routes: Routes = [
  {path: "login", component: LoginComponent},
  {path: "adduser", component: UserFormComponent},
  { path: '', component: MainpageComponent},
  { path: '*', component: MainpageComponent},
  {path: 'cinemas', component: CinemaListComponent}
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


