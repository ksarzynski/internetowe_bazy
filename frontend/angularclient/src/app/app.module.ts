import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { UserListComponent } from './user-list/user-list.component';
import { UserFormComponent } from './user-form/user-form.component';
import { UserService } from './service/user/user.service';
import { LoginFormComponent } from './login-form/login-form.component';
import { LoginComponent } from './login/login.component';
import { MainpageComponent } from './mainpage/mainpage.component';
import { CinemaListComponent } from './list/cinema-list/cinema-list.component';
import { HallListComponent } from './list/hall-list/hall-list.component';
import { SeancesListComponent } from './list/seances-list/seances-list.component';
import { MoviesListComponent } from './list/movies-list/movies-list.component';
import {ModalModule} from "./modal/_modal";

@NgModule({
  declarations: [
    AppComponent,
    UserListComponent,
    UserFormComponent,
    LoginFormComponent,
    LoginComponent,
    MainpageComponent,
    CinemaListComponent,
    HallListComponent,
    SeancesListComponent,
    MoviesListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    ModalModule
  ],
  providers: [UserService],
  bootstrap: [AppComponent]
})
export class AppModule { }
