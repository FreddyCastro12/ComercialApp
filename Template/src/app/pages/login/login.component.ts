import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Client } from '../components/client_component/Model/Client';
import { ServiceService } from '../components/client_component/Service/service.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
  providers: [ServiceService]
})
export class LoginComponent implements OnInit {
  email: String;
  password: String;
  client:Client = new Client;

  constructor(public clientService: ServiceService, private router:Router) {}

  ngOnInit() {
  }

  loginClient() {
    this.clientService.loginCliente(this.email, this.password).subscribe(res => {
      this.client=res;
      sessionStorage.setItem("idClient",this.client.id+"");
      localStorage.setItem("Email", this.client.email+"")
      this.router.navigate(["/dashboard"]);
    });
  }
}
