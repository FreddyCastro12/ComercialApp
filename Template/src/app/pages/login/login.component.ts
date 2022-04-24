import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
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

  constructor(public clientService: ServiceService, private router:Router) {}

  ngOnInit() {
  }

  loginClient() {
    this.clientService.loginCliente(this.email, this.password).subscribe(res => {
      let respuesta = JSON.parse(JSON.stringify(res));
      console.log(respuesta);
    });
  }
}
