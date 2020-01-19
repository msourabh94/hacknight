import { BrowserModule } from "@angular/platform-browser";
import { NgModule } from "@angular/core";
import { BrowserAnimationsModule } from "@angular/platform-browser/animations";

import { AppRoutingModule } from "./app-routing.module";
import { AppComponent } from "./app.component";
import { RegistrationComponent } from "./registration/registration.component";
import { SigninComponent } from "./signin/signin.component";
import { HttpClientModule, HTTP_INTERCEPTORS } from "@angular/common/http";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { LoginServiceService } from "./providers/login-service.service";
import { StorageServiceModule } from "angular-webstorage-service";

import { ModalModule } from "ngx-bootstrap";
import { JwtInterceptor } from "./providers/JwtInterceptor.interceptor";
import { CarouselModule } from "ngx-bootstrap";
import { HeaderComponent } from "./header/header.component";
import { HomeComponent } from "./home/home.component";
import { BsDatepickerModule } from "ngx-bootstrap";
import { UtilService } from "./providers/Util.service";

@NgModule({
  declarations: [
    AppComponent,
    RegistrationComponent,
    SigninComponent,
    HeaderComponent,
    HomeComponent
  ],
  imports: [
    BrowserAnimationsModule,
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    BsDatepickerModule.forRoot(),

    //Bootstrap modules
    ModalModule.forRoot(),
    CarouselModule.forRoot(),
    StorageServiceModule
  ],
  providers: [
    LoginServiceService,
    UtilService,
    { provide: HTTP_INTERCEPTORS, useClass: JwtInterceptor, multi: true }
  ],
  bootstrap: [AppComponent]
})
export class AppModule {}
