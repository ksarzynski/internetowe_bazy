import { Component, OnInit } from '@angular/core';
import {User} from "../../model/user";
import {AuthenticationService} from "../../service/authentication/authentication.service";
import {Router} from "@angular/router";
import {HttpResponse} from "@angular/common/http";


@Component({
  selector: 'app-add-user-form',
  templateUrl: './add-user-form.component.html',
  styleUrls: ['./add-user-form.component.css']
})
export class AddUserFormComponent implements OnInit {
  user: User = new User();
  role: string = '';

  constructor(private authService: AuthenticationService) { }

  ngOnInit(): void {
  }

  onSubmit() {
    this.authService.registerUser(this.user,this.role).subscribe((response: HttpResponse<any>) => {
      const username = response.body["username"];
      const email = response.body["email"];
      window.confirm("Zarejestrowano nowego użytkownika")
    },(error) => {
      window.confirm("Wystąpił błąd!")
    });
  }

}
