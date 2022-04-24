import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Cliente } from '../Model/Cliente';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {

  constructor(private http:HttpClient) { }
  UrlCliente = 'http://localhost:8080/comercialApp/client';

  createCliente(cliente:Cliente){
    return this.http.post<Cliente>(this.UrlCliente + "/addClient",cliente);
  }
  listClients(){
    return this.http.get<Cliente[]>(this.UrlCliente+"/listClients");
  }
  updateCliente(cliente:Cliente){
    return this.http.put<Cliente>(this.UrlCliente+"/editClient",cliente);
  }
  deleteCliente(id:number){
    return this.http.delete<Cliente>(this.UrlCliente+"/deleteClient/" + id);
  }

}