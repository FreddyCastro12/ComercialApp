import { Component, OnInit } from '@angular/core';
import { Product } from 'src/app/pages/components/product_client/Model/Product';
import { Router } from '@angular/router';
import { ServiceService } from 'src/app/pages/components/product_client/Service/service.service';
import { ToastrService } from 'ngx-toastr';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-producto',
  templateUrl: './producto.component.html',
  styleUrls: ['./producto.component.scss']
})
export class ProductoComponent implements OnInit {

  product: Product = new Product;
  products: Product[];
  constructor(private router: Router, private service: ServiceService, private toastr: ToastrService) { }

  ngOnInit(): void {
    this.listProducts();
  }

  saveProduct(productForm: NgForm) {
    if (this.product.id) {
      this.service.updateProduct(this.product).subscribe(data => {
        this.toastr.success('El producto se modificó con exito');
        this.resetearFormulario(productForm);
        this.listProducts();
      })
    } else {
      this.service.createProduct(this.product).subscribe(data => {
        this.toastr.success("El producto se agrego con exito");
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
}
