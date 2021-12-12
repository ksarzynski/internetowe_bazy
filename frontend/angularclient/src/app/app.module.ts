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
import {AuthInterceptor} from "./service/authentication/authInterceptor";

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
    NavbarComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    ModalModule,
    MatToolbarModule,
  ],
  exports: [
    MatToolbarModule
  ],
  // {provide:HTTP_INTERCEPTORS, useClass:AuthInterceptor, multi:true}
  providers: [UserService,NavbarComponent],
  bootstrap: [AppComponent]
})

export class AppModule { }
