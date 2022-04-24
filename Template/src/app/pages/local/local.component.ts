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
  constructor(public localService: ServiceService) { }

  ngOnInit(): void {
  }

  addLocal() {
    console.log(this.local);
  }
}
