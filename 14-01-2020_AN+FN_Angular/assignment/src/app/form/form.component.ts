import { Component, OnInit } from '@angular/core';
import { FormService } from "../providers/formService";
import { FormGroup,FormControl, Validators } from "@angular/forms";
import {Router,ActivatedRoute, Params } from "@angular/router";
import { User } from '../models/user.model';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent implements OnInit {

  constructor(private formService:FormService,private router:Router) { }

  userForm:FormGroup;

  ngOnInit() { 
      this.initform();
  }

  initform(){
    this.userForm=new FormGroup({
      "credentials":new FormGroup({
        "name":new FormControl("",[Validators.required]),
        "age":new FormControl(null,[Validators.required, Validators.pattern(/^-?(0|[1-9]\d*)?$/)])
      }),
      "contactInfo":new FormGroup({
        "phone":new FormControl("",[Validators.required, Validators.pattern(/^\d{10}$/)]),
        "email":new FormControl("",[Validators.required,Validators.email])
      })
    })
  }

  onSubmit(){
    this.formService.addData(this.userForm.value);
    this.router.navigate(["/display"]);
  }


}
