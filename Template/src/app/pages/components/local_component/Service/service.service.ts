import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Local } from '../Model/Local';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {

  constructor(private http:HttpClient) { }
  UrlLocal = 'http://localhost:8080/local';

  createLocal(local:Local){
    return this.http.post<Local>(this.UrlLocal + "/addLocal",local);
  }
  listLocals(){
    return this.http.get<Local[]>(this.UrlLocal+"/listLocal");
  }
  updateLocal(local:Local){
    return this.http.put<Local>(this.UrlLocal+"/editLocal",local);
  }
  deleteLocal(id:number){
    return this.http.delete<Local>(this.UrlLocal+"/deleteLocal/" + id);
  }

}