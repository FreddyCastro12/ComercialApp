import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Menu } from '../Model/Menu';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {

  constructor(private http:HttpClient) { }
  UrlLocal = 'http://localhost:8080/comercialApp/client';

  getMenus(id:number){
    return this.http.get<Menu[]>(this.UrlLocal+"/getMenus/" + id);
  }

}