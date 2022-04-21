import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Service } from '../Model/Service'

@Injectable({
  providedIn: 'root'
})
export class ServiceService {

  constructor(private http:HttpClient) { }
  UrlService = 'http://localhost:8080/service';

  createService(service:Service){
    return this.http.post<Service>(this.UrlService + "/addService",service);
  }
  listServices(){
    return this.http.get<Service[]>(this.UrlService+"/listService");
  }
  updateService(service:Service){
    return this.http.put<Service>(this.UrlService+"/editService",service);
  }
  deleteService(id:number){
    return this.http.delete<Service>(this.UrlService+"/deleteService/" + id);
  }

}