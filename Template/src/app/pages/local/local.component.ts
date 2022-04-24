import { Component, OnInit } from '@angular/core'
import { Local } from '../components/local_component/Model/Local';
import { ServiceService } from '../components/local_component/Service/service.service';

@Component({
  selector: 'app-local',
  templateUrl: './local.component.html',
  styleUrls: ['./local.component.scss'],
  providers: [ServiceService]
})
export class LocalComponent implements OnInit {

  local: Local = new Local;
  locales: Local[];
  constructor(public localService: ServiceService) { }

  ngOnInit(): void {
    this.getlocales();
  }

  addLocal() { 
    if (this.local.id) {
      this.localService.updateLocal(this.local.id, this.local).subscribe(res => {
        let respuesta = JSON.parse(JSON.stringify(res));
        console.log(respuesta);
        window.location.reload();
      });
    } else {
      this.localService.createLocal(this.local).subscribe(res => {
        let respuesta = JSON.parse(JSON.stringify(res));
        console.log(respuesta);
        window.location.reload();
      });
    }
  }

  getlocales() {
    this.localService.listLocals().subscribe(res => {
      let respuesta = JSON.parse(JSON.stringify(res));   
      this.locales = respuesta as Local[];
      console.log(this.locales);      
    })
  }

  updateLocal(local: Local) {
    this.local = local;
  }

  deleteLocal(id: number) {
    if (confirm('Esta seguro de eliminar este registro')) {
      this.localService.deleteLocal(id).subscribe(res => {
        let respuesta = JSON.parse(JSON.stringify(res));
        console.log(respuesta);
        window.location.reload();
      });
    }
  }
}
