import { Component, OnInit } from "@angular/core";
import { FormGroup, FormControl } from "@angular/forms";
import { Router, ActivatedRoute } from "@angular/router";
import { LoginServiceService } from "../providers/login-service.service";
import { RegisterRequest } from "../models/RegisterRequest";
import { UtilService } from "../providers/Util.service";

@Component({
  selector: "app-registration",
  templateUrl: "./registration.component.html",
  styleUrls: ["./registration.component.css"]
})
export class RegistrationComponent implements OnInit {
  registerBorrowFirm: boolean = false;
  registerBorrowIndi: boolean = false;

  registerLenderFirm: boolean = false;
  registerLenderIndi: boolean = false;

  registrationRequest: RegisterRequest;

  registrationForm = new FormGroup({
    email: new FormControl(""),
    password: new FormControl(""),
    userType: new FormControl(""),
    firstName: new FormControl(""),
    lastName: new FormControl(""),
    dob: new FormControl(""),
    fathersName: new FormControl(""),
    pan: new FormControl(""),
    presentAddress: new FormControl(""),
    permAddress: new FormControl(""),
    presentPermSame: new FormControl(""),
    tan: new FormControl(""),
    cin: new FormControl(""),
    incorpDate: new FormControl(""),
    directorName: new FormControl(""),
    directorMobileNumber: new FormControl(""),
    firmAddress: new FormControl("")
  });

  userTypes = [
    { name: "Lender", value: "L" },
    { name: "Borrower", value: "B" }
  ];

  constructor(
    private router: Router,
    private loginService: LoginServiceService,
    private activatedRoute: ActivatedRoute,
    private utilService: UtilService
  ) {}

  ngOnInit() {}

  submitForm() {
    let dobString = this.utilService.formatDate(
      this.registrationForm.controls["dob"].value
    );
    let incorpDate = this.utilService.formatDate(
      this.registrationForm.controls["incorpDate"].value
    );
    console.log(JSON.stringify(this.registrationForm.value));
    this.registrationRequest = this.registrationForm.value;
    this.registrationRequest.dob = dobString;
    this.registrationRequest.incorpDate = incorpDate;
    this.registrationRequest.dob = this.loginService
      .register(this.registrationRequest)
      .subscribe(
        res => {
          if (res.hasOwnProperty("userRegistrationRequest")) {
            this.loginService.userDetails = res["userRegistrationRequest"];
          }
          this.router.navigateByUrl(`/home`);
        },
        err => {}
      );
  }
}
