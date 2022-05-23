import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ServiceService } from 'src/app/pages/components/client_component/Service/service.service';
import { Client } from '../components/client_component/Model/Client';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.scss']
})
export class UserProfileComponent implements OnInit {

  client:Client = new Client;
  constructor(private router:Router, private service:ServiceService) { }

  ngOnInit() {
    let idClient = localStorage.getItem("idClient");
    this.service.getClient(Number(idClient))
    .subscribe(data=>{
      this.client=data;
    })
  }

  editClient(){
    this.service.updateCliente(this.client)
    .subscribe(data=>{
      this.client=data;
      alert("El cliente se actualizo con exito")
      window.location.reload();
    })
  }

}
