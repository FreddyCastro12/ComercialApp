import { Component, OnInit } from '@angular/core';
import { Product } from 'src/app/pages/components/product_client/Model/Product';
import { Router } from '@angular/router';
import { ServiceService } from 'src/app/pages/components/product_client/Service/service.service';
import { ServiceService as LocalService } from 'src/app/pages/components/local_component/Service/service.service';
import { ToastrService } from 'ngx-toastr';
import { NgForm } from '@angular/forms';
import { Local } from '../components/local_component/Model/Local';

@Component({
  selector: 'app-producto',
  templateUrl: './producto.component.html',
  styleUrls: ['./producto.component.scss']
})
export class ProductoComponent implements OnInit {

  product: Product = new Product;
  products: Product[];
  locals: Local[];
  idLocal: string;
  constructor(private router: Router, private service: ServiceService, private toastr: ToastrService, private localService: LocalService) { }

  ngOnInit(): void {
    this.listProducts();
    this.listLocals();
  }

  saveProduct(productForm: NgForm) {
    if (this.product.id) {
      this.localService.getLocal(Number(this.idLocal)).subscribe(data => {
        this.product.local = data;
      })
      this.service.updateProduct(this.product).subscribe(data => {
        this.toastr.success("Exito", 'El producto se modificó con exito', {
          timeOut: 5000,
        });
        this.resetearFormulario(productForm);
        this.listProducts();
      })
    } else {
      this.localService.getLocal(Number(this.idLocal)).subscribe(data => {
        this.product.local = data;
      })
      this.service.createProduct(this.product).subscribe(data => {
        this.toastr.success("Exito", "El producto se agrego con exito", {
          timeOut: 5000,
        });
        this.resetearFormulario(productForm);
        this.listProducts()
      })
    }
  }

  updateProduct(product: Product) {
    this.product = product
  }

  deleteProduct(product: Product) {
    this.service.deleteProduct(product.id).subscribe(data => {
      this.toastr.success("El producto se elimino con exito");
      this.listProducts()
    })
  }

  listProducts(){
    this.service.listProducts().subscribe(data => {
      this.products = data;
    })
  }

  resetearFormulario(form?: NgForm) {
    if (form) {
      form.reset();
      this.product = new Product;
      this.listProducts();
    }
  }

  listLocals(){
    this.localService.listLocals().subscribe(data => {
      this.locals = data;
    })
  }
}
