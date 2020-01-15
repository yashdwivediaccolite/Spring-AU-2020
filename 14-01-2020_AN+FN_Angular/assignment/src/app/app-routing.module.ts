import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { FormComponent } from './form/form.component';
import { DisplayFormComponent } from './display-form/display-form.component';

const routes: Routes = [
  {path:"input",component:FormComponent},
  {path:"display",component:DisplayFormComponent},
  {path:"",redirectTo:"input",pathMatch:"full"},
  {path:"**",redirectTo:"input"}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
