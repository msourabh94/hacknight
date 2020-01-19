import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { SignIn } from "../models/SignIn";
import { CoreEnvironment } from "@angular/core/src/render3/jit/compiler_facade_interface";

import { environment } from "../../environments/environment";
import { RegisterRequest } from "../models/RegisterRequest";
import { UserDetails } from "../models/UserDetails";

@Injectable({
  providedIn: "root"
})
export class LoginServiceService {
  environment = environment;
  userDetails = {};

  constructor(private http: HttpClient) {}

  login(loginRequest: SignIn) {
    const apiUrl = `${this.environment.backendUrl}/login`;
    return this.http.post(apiUrl, loginRequest);
  }

  register(registerRequest: RegisterRequest) {
    const apiUrl = `${this.environment.backendUrl}/register`;
    return this.http.post(apiUrl, registerRequest);
  }

  fetchUserDetails(token: string) {
    const apiUrl = `${this.environment.backendUrl}/userdetails`;
    return this.http.get(apiUrl);
  }
}
