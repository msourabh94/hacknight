import { Component, OnInit } from "@angular/core";
import { LoginServiceService } from "../providers/login-service.service";
import { SignIn } from "../models/SignIn";
import { FormGroup, FormControl, Validators } from "@angular/forms";
import { Router } from "@angular/router";

import * as jwt_decode from "jwt-decode";
import { hasOwnProp } from "ngx-bootstrap/chronos/utils/type-checks";

@Component({
  selector: "app-signin",
  templateUrl: "./signin.component.html",
  styleUrls: ["./signin.component.css"]
})
export class SigninComponent implements OnInit {
  signInRequest: SignIn;
  signInForm = new FormGroup({
    email: new FormControl("", Validators.required),
    password: new FormControl("", Validators.required)
  });
  constructor(
    private loginService: LoginServiceService,
    private router: Router
  ) {}
  ngOnInit() {}

  login() {
    this.signInRequest = this.signInForm.valid ? this.signInForm.value : null;
    if (!(this.signInRequest === null)) {
      this.loginService.login(this.signInRequest).subscribe(
        res => {
          if (res.hasOwnProperty("jwttoken")) {
            localStorage.setItem("access_token", res["jwttoken"]);
            const userDetails = jwt_decode(
              localStorage.getItem("access_token")
            );
            if (
              res.hasOwnProperty("accountType") &&
              res["accountType"] === "A"
            ) {
              this.router.navigateByUrl("/home/admin");
            } else if (
              res.hasOwnProperty("accountType") &&
              res["accountType"] === "L"
            ) {
              this.router.navigateByUrl("/home/lender");
            } else if (
              res.hasOwnProperty("accountType") &&
              res["accountType"] === "B"
            ) {
              this.router.navigateByUrl("/home/borrower");
            }
          }
        },
        err => {}
      );
    }
  }
}
