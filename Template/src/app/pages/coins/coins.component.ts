import { Component, OnInit } from '@angular/core';
import { Client } from '../components/client_component/Model/Client';
import { ServiceService } from 'src/app/pages/components/client_component/Service/service.service';
import { ToastrService } from 'ngx-toastr';
import { Router } from '@angular/router';

@Component({
  selector: 'app-coins',
  templateUrl: './coins.component.html',
  styleUrls: ['./coins.component.css']
})
export class CoinsComponent implements OnInit {
  client:Client = new Client;

  constructor(private service:ServiceService, private toastr: ToastrService, private router: Router) { }

  ngOnInit(): void {
    let idClient = localStorage.getItem("idClient");
    this.service.getClient(Number(idClient))
    .subscribe(data=>{
      this.client=data;
    })
  }

  addAmount(){
    this.toastr.success("Exito", 'Compra realizada con exito', {
      timeOut: 5000,
    });
    this.router.navigate(["/dashboard"])
  }
}
