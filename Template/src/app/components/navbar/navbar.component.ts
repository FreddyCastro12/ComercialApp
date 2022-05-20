import { Component, OnInit, ElementRef } from '@angular/core';
import { ROUTES } from '../sidebar/sidebar.component';
import { Location, LocationStrategy, PathLocationStrategy } from '@angular/common';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, FormArray } from '@angular/forms';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {
  word:string = "";
  public focus;
  public listTitles: any[];
  public location: Location;
  public nameClient: String;
  public amountClient: String;

  constructor(location: Location,  private element: ElementRef, private router: Router) {
    this.location = location;
  }

  ngOnInit() {
    this.listTitles = ROUTES.filter(listTitle => listTitle);
    this.nameClient = localStorage.getItem("Name");
    this.amountClient = localStorage.getItem("Amount");
  }
  getTitle(){
    var titlee = this.location.prepareExternalUrl(this.location.path());
    if(titlee.charAt(0) === '#'){
        titlee = titlee.slice( 1 );
    }

    for(var item = 0; item < this.listTitles.length; item++){
        if(this.listTitles[item].path === titlee){
            return this.listTitles[item].title;
        }
    }
    return 'Dashboard';
  }

  logout(){
    localStorage.removeItem("idClient")
    sessionStorage.removeItem("idClient")
    localStorage.removeItem("Email")
    this.router.navigate(["/login"])
  }

  search(){
    this.router.navigate(["/dashboard"])
    localStorage.setItem("findWord",this.word)
  }

}
