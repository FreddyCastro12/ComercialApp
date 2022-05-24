import { Component, OnInit } from '@angular/core';
import { Client } from '../components/client_component/Model/Client';
import { Router } from '@angular/router';
import { ServiceService } from 'src/app/pages/components/client_component/Service/service.service';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {
  client:Client = new Client;
  constructor(private router:Router, private service:ServiceService, private toastr: ToastrService) { }

  ngOnInit() {
  }
  
  addCliente(){
    this.service.createCliente(this.client).subscribe(data => {
      this.toastr.success("Exito", "El cliente se registro con exito", {
        timeOut: 5000,
      });
      this.router.navigate(["/login"]);
    })
  }
}
