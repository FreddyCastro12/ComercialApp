import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Menu } from '../Model/Menu';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {

  constructor(private http:HttpClient) { }
  UrlMenuClient = 'http://localhost:8080/comercialApp/client';
  
  UrlMenu = 'http://localhost:8080/comercialApp/menu';

  createMenu(menu:Menu, client: number, admin: number){
    return this.http.post<Menu>(this.UrlMenu + "/addMenu/" + client + "/" + admin, menu);
  }
  listMenus(){
    return this.http.get<Menu[]>(this.UrlMenu+"/listMenus");
  }
  listClientTypeMenus(idMenu: number){
    return this.http.get<number[]>(this.UrlMenu+"/listClientTypeMenus/" + idMenu);
  }
  updateMenu(menu:Menu, client: number, admin: number){
    return this.http.put<Menu>(this.UrlMenu+"/editMenu/" + client + "/" + admin, menu);
  }
  deleteMenu(id:number){
    return this.http.delete<Menu>(this.UrlMenu+"/deleteMenu/" + id);
  }
  getMenus(id:number){
    return this.http.get<Menu[]>(this.UrlMenuClient+"/getMenus/" + id);
  }

}