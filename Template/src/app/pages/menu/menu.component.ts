import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ServiceService } from 'src/app/pages/components/menu_component/Service/service.service';
import { ToastrService } from 'ngx-toastr';
import { NgForm } from '@angular/forms';
import { Menu } from '../components/menu_component/Model/Menu';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.scss']
})
export class MenuComponent implements OnInit {

  menu: Menu = new Menu;
  menus: Menu[];

  constructor(private router: Router, private service: ServiceService, private toastr: ToastrService) { }

  ngOnInit(): void {
    this.listMenus();
  }

  saveMenu(menuForm: NgForm) {
    if (this.menu.id) {
      this.service.updateMenu(this.menu).subscribe(data => {
        this.toastr.success('El menu se modificó con exito');
        this.resetearFormulario(menuForm);
        this.listMenus();
      })
    } else {
      this.service.createMenu(this.menu).subscribe(data => {
        this.toastr.success("El menu se agrego con exito");
        this.resetearFormulario(menuForm);
        this.listMenus()
      })
    }
  }

  updateMenu(menu: Menu) {
    this.menu = menu
  }

  deleteMenu(menu: Menu) {
    this.service.deleteMenu(menu.id).subscribe(data => {
      this.toastr.success("El menu se elimino con exito");
      this.listMenus()
    })
  }

  listMenus(){
    this.service.listMenus().subscribe(data => {
      this.menus = data;
    })
  }

  resetearFormulario(form?: NgForm) {
    if (form) {
      form.reset();
      this.menu = new Menu;
      this.listMenus();
    }
  }
}
