import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from '../entities/user';
import { Credentials } from '../entities/credentials';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  constructor(private httpClient: HttpClient) { }

  host: string = "http://localhost:9002/cls";

  auth: string = this.host + "/auth";
  login: string = this.auth + "/login";
  signup: string = this.auth + "/signup";

  users: string = this.host + "/users";

  registerUser(user: User)
  {
    let header: HttpHeaders = new HttpHeaders();
    header.set("content-type", "application.json");
    header.set('Access-Control-Allow-Origin', '*');

    return this.httpClient.post(this.signup, user, {headers: header});
  }

  loginUser(credential: Credentials)
  {
    return this.httpClient.post(this.login, credential);
  }
}