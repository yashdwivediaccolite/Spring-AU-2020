import { Component, OnInit ,OnDestroy} from '@angular/core';
import {FormService} from "../providers/formService";
import { User } from "../models/user.model"
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-display-form',
  templateUrl: './display-form.component.html',
  styleUrls: ['./display-form.component.css']
})
export class DisplayFormComponent implements OnInit,OnDestroy {

  constructor(private formService:FormService) { }

  userData:User[];
  dataSubscription:Subscription;

  ngOnInit() {
    this.userData=this.formService.getData();
    this.dataSubscription=this.formService.dataUpdated.subscribe((data:User[])=>{
      this.userData=data;
    })
  }

  onDelete(i:number){
    this.formService.deleteData(i);
  }

  ngOnDestroy(){
    this.dataSubscription.unsubscribe();
  }

}
