import { Injectable } from "@angular/core";
import { Subject } from 'rxjs';
import { User } from "../models/user.model"

@Injectable({
    "providedIn":"root"
})
export class FormService{
    userData:User[]=[]
    dataUpdated=new Subject<User[]>();

    addData(data){
        this.userData.push(data);
    }

    getData(){
        return this.userData.slice();
    }

    deleteData(index:number){
        this.userData.splice(index,1);
        this.dataUpdated.next(this.userData.slice());
    }

}
