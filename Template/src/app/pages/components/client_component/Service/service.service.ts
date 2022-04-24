import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Client } from '../Model/Client';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {

  constructor(private http:HttpClient) { }
  UrlCliente = 'http://localhost:8080/comercialApp/client';

  createCliente(cliente:Client){
    return this.http.post<Client>(this.UrlCliente + "/addClient",cliente);
  }
  listClients(){
    return this.http.get<Client[]>(this.UrlCliente+"/listClients");
  }
  updateCliente(cliente:Client){
    return this.http.put<Client>(this.UrlCliente+"/editClient",cliente);
  }
  deleteCliente(id:number){
    return this.http.delete<Client>(this.UrlCliente+"/deleteClient/" + id);
  }
  loginCliente(email:String, password:String){
    return this.http.get<Client>(this.UrlCliente+"/loginClient/" + email + "/" + password);
  }
}