import { Component, OnInit } from '@angular/core';
import { Service } from '../components/service_component/Model/Service';
import { ServiceService } from '../components/service_component/Service/service.service';

@Component({
  selector: 'app-servicio',
  templateUrl: './servicio.component.html',
  styleUrls: ['./servicio.component.scss'],
  providers: [ServiceService]
})
export class ServicioComponent implements OnInit {

  service: Service = new Service;
  services: Service[];
  constructor(public serviceService: ServiceService) { }

  ngOnInit(): void {
    this.getServices();
  }

  addService() { 
    if (this.service.id) {
      this.serviceService.updateService(this.service.id, this.service).subscribe(res => {
        let respuesta = JSON.parse(JSON.stringify(res));
        console.log(respuesta);
        window.location.reload();
      });
    } else {
      this.serviceService.createService(this.service).subscribe(res => {
        let respuesta = JSON.parse(JSON.stringify(res));
        console.log(respuesta);
        window.location.reload();
      });
    }
  }

  getServices() {
    this.serviceService.listServices().subscribe(res => {
      let respuesta = JSON.parse(JSON.stringify(res));   
      this.services = respuesta as Service[];
      console.log(this.service);      
    })
  }

  updateService(service: Service) {
    this.service = service;
  }

  deleteService(id: number) {
    if (confirm('Esta seguro de eliminar este registro')) {
      this.serviceService.deleteService(id).subscribe(res => {
        let respuesta = JSON.parse(JSON.stringify(res));
        console.log(respuesta);
        window.location.reload();
      });
    }
  }
}
