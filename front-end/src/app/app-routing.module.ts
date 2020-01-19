import { NgModule } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";
import { SigninComponent } from "./signin/signin.component";
import { RegistrationComponent } from "./registration/registration.component";
import { AppComponent } from "./app.component";
import { HomeComponent } from "./home/home.component";

const routes: Routes = [
  { path: "", component: AppComponent },
  { path: "login", component: SigninComponent },
  {
    path: "registration/:type",
    component: RegistrationComponent
  },
  {
    path: "home/:type",
    component: HomeComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
