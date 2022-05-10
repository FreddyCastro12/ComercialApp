import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ServiceService } from 'src/app/pages/components/menu_component/Service/service.service';

declare interface RouteInfo {
    path: string;
    title: string;
    icon: string;
    class: string;
}
export var ROUTES: RouteInfo[] = [];

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.scss'],
  providers: [ServiceService]
})
export class SidebarComponent implements OnInit {

  public menuItems: any[];
  public isCollapsed = true;

  constructor(private router: Router, private serviceMenu: ServiceService) { }

  ngOnInit() {
    this.getMenus(); 
    this.menuItems = ROUTES.filter(menuItem => menuItem);
    this.router.events.subscribe((event) => {
      this.isCollapsed = true;
   });
  }

  getMenus(){
    let idClient = sessionStorage.getItem("idClient");
    this.serviceMenu.getMenus(Number(idClient)).subscribe(res => {
      res.forEach(value => {
        this.menuItems.push({ path: value.path, title: value.title,  icon: value.icon, class: value.clase });
      });
      console.log(ROUTES);
    });;
  }

  logout(){
    localStorage.removeItem("idClient")
    sessionStorage.removeItem("idClient")
    localStorage.removeItem("Email")
    this.router.navigate(["/login"])
  }
}
