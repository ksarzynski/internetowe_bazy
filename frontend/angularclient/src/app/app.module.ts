import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import { AppComponent } from './app.component';
import { UserListComponent } from './user-list/user-list.component';
import { UserFormComponent } from './user-form/user-form.component';
import { UserService } from './service/user/user.service';
import { LoginFormComponent } from './login-form/login-form.component';
import { MainpageComponent } from './mainpage/mainpage.component';
import { CinemaListComponent } from './list/cinema-list/cinema-list.component';
import { HallListComponent } from './list/hall-list/hall-list.component';
import { SeancesListComponent } from './list/seances-list/seances-list.component';
import { MoviesListComponent } from './list/movies-list/movies-list.component';
import {ModalModule} from "./modal/_modal";
import { RegisterComponent } from './register/register.component';
import {MatToolbarModule} from "@angular/material/toolbar";
import { NavbarComponent } from './navbar/navbar.component';
import { DirectorsListComponent } from './list/directors-list/directors-list.component';
import { ActorsListComponent } from './list/actors-list/actors-list.component';
import { MoviePageComponent } from './pages/movie-page/movie-page.component';
import { ReservationPageComponent } from './reservation-page/reservation-page.component';
import { ReservationService } from './service/reservation/reservation.service';
import { MatGridListModule } from '@angular/material/grid-list';
import {HttpConfigInterceptorService} from "./interceptor/http-config-interceptor.service";
import { AddUserFormComponent } from './forms/add-user-form/add-user-form.component';
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatOptionModule} from "@angular/material/core";
import {MatSelectModule} from "@angular/material/select";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';


@NgModule({
  declarations: [
    AppComponent,
    UserListComponent,
    UserFormComponent,
    LoginFormComponent,
    MainpageComponent,
    CinemaListComponent,
    HallListComponent,
    SeancesListComponent,
    MoviesListComponent,
    RegisterComponent,
    NavbarComponent,
    DirectorsListComponent,
    ActorsListComponent,
    MoviePageComponent,
    NavbarComponent,
    ReservationPageComponent,
    AddUserFormComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    ModalModule,
    MatToolbarModule,
    MatGridListModule,
    MatFormFieldModule,
    MatOptionModule,
    MatSelectModule,
    BrowserAnimationsModule
  ],
  exports: [
    MatToolbarModule
  ],
  providers: [UserService,NavbarComponent,ReservationService, { provide: HTTP_INTERCEPTORS, useClass: HttpConfigInterceptorService, multi: true }, ],
  bootstrap: [AppComponent]
})

export class AppModule { }
