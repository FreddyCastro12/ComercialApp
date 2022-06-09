import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ServiceService } from 'src/app/pages/components/menu_component/Service/service.service';
import { ToastrService } from 'ngx-toastr';
import { NgForm } from '@angular/forms';
import { Menu } from '../components/menu_component/Model/Menu';
declare var $: any

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.scss']
})
export class MenuComponent implements OnInit {

  menu: Menu = new Menu;
  menus: Menu[];
  admin = 0;
  client = 0;
  listMenusClient = [];

  constructor(private router: Router, private service: ServiceService, private toastr: ToastrService) { }

  ngOnInit(): void {
    this.listMenus();
  }

  saveMenu(menuForm: NgForm) {
    if (this.menu.id) {
      this.service.updateMenu(this.menu, this.client, this.admin).subscribe(data => {
        this.toastr.success("Exito", 'El menu se modificó con exito', {
          timeOut: 5000,
        });
        this.resetearFormulario(menuForm);
        this.listMenus();
      })
    } else {
      this.service.createMenu(this.menu, this.client, this.admin).subscribe(data => {
        this.toastr.success("Exito", "El menu se agrego con exito", {
          timeOut: 5000,
        });
        this.resetearFormulario(menuForm);
        this.listMenus()
      })
    }
  }

  updateMenu(menu: Menu) {
    this.menu = menu
    this.listClientTypeMenus(menu.id);
  }

  deleteMenu(menu: Menu) {
    this.service.deleteMenu(menu.id).subscribe(data => {
      this.toastr.success("Exito", "El menu se elimino con exito", {
        timeOut: 5000,
      });
      this.listMenus()
    })
  }

  listMenus(){
    this.service.listMenus().subscribe(data => {
      this.menus = data;
    })
  }

  listClientTypeMenus(idMenu: number){
    $("#checkAdmin").prop('checked', false);
    $("#checkClient").prop('checked', false);
    this.service.listClientTypeMenus(idMenu).subscribe(data => {
      data.forEach(element => {
        if(element == 1){
          $("#checkAdmin").prop('checked', true);
          this.admin = 1;
        }else if(element == 2){
          $("#checkClient").prop('checked', true);
          this.client = 2;
        }
      });
    })
  }

  resetearFormulario(form?: NgForm) {
    if (form) {
      form.reset();
      this.menu = new Menu;
      this.listMenus();
      $("#checkAdmin").prop('checked', false);
      $("#checkClient").prop('checked', false);
    }
  }

  addClient(checked){
    if(checked.target.checked){
      this.client = 2;
    }else{
      this.client = 0;
    }
  }

  addAdmin(checked){
    if(checked.target.checked){
      this.admin = 1;
    }else{
      this.admin = 0;
    }
  }
}
