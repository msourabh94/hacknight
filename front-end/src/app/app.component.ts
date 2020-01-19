import {
  Component,
  ViewChild,
  ElementRef,
  TemplateRef,
  OnInit
} from "@angular/core";
import { BsModalRef, BsModalService } from "ngx-bootstrap/modal";
import { LoginServiceService } from "./providers/login-service.service";
import { Router, ActivatedRoute, NavigationEnd } from "@angular/router";

import { filter } from "rxjs/operators";

@Component({
  selector: "app-root",
  templateUrl: "./app.component.html",
  styleUrls: ["./app.component.css"]
})
export class AppComponent implements OnInit {
  title = "devengers-shakaal";
  @ViewChild("register") registerPopup: ElementRef;
  modalRef: BsModalRef;
  config = {
    backdrop: true,
    ignoreBackdropClick: true,
    keyboard: false
  };
  userLoggedIn: boolean = false;

  //carousel config starts
  myInterval = 1500;
  activeSlideIndex = 0;
  showCarousel: boolean = true;

  activeModal: boolean = false;

  slides = [
    { image: "assets/images/lenden1.jpg" },
    { image: "assets/images/lenden2.jpg" },
    { image: "assets/images/lenden3.jpg" }
  ];

  constructor(
    private modalService: BsModalService,
    private loginService: LoginServiceService,
    private router: Router,
    private activatedRoute: ActivatedRoute
  ) {}

  ngOnInit() {
    this.router.events
      .pipe(filter(event => event instanceof NavigationEnd))
      .subscribe((event: NavigationEnd) => {
        if (event.url.length > 1) {
          this.showCarousel = false;
          this.activeModal ? this.modalRef.hide() : "";
        } else {
          this.openModal();
          this.activeModal = true;
        }
      });
  }

  openModal() {
    this.modalRef = this.modalService.show(this.registerPopup, this.config);
  }

  navigate(param) {
    if (param === "lender") {
      this.router.navigateByUrl("/registration/lender");
    } else if (param === "borrower") {
      this.router.navigateByUrl("/registration/borrower");
    } else {
      this.router.navigateByUrl("/login");
    }
  }
}
