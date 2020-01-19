import { Component, OnInit } from "@angular/core";
import { Router, NavigationEnd } from "@angular/router";
import { LoginServiceService } from "../providers/login-service.service";
import * as jwt_decode from "jwt-decode";
import { filter } from "rxjs/operators";

@Component({
  selector: "app-header",
  templateUrl: "./header.component.html",
  styleUrls: ["./header.component.css"]
})
export class HeaderComponent implements OnInit {
  userDetails = {};

  constructor(
    private router: Router,
    private loginService: LoginServiceService
  ) {}

  ngOnInit() {
    this.router.events
      .pipe(filter(event => event instanceof NavigationEnd))
      .subscribe((event: NavigationEnd) => {
        if (event.url.length > 1) {
          if (localStorage.getItem("access_token")) {
            this.userDetails = jwt_decode(localStorage.getItem("access_token"));
          }
        }
      });
  }

  logout() {
    localStorage.removeItem("access_token");
    this.router.navigateByUrl("/");
  }
}
