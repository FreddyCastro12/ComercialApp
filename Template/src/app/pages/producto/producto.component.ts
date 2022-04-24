import { Component, OnInit } from '@angular/core';
import { Product } from 'src/app/pages/components/product_client/Model/Product';
import { Router } from '@angular/router';
import { ServiceService } from 'src/app/pages/components/product_client/Service/service.service';

@Component({
  selector: 'app-producto',
  templateUrl: './producto.component.html',
  styleUrls: ['./producto.component.scss']
})
export class ProductoComponent implements OnInit {

  product:Product = new Product;
  products:Product[];
  constructor(private router:Router, private service:ServiceService) { }

  ngOnInit(): void {
    this.service.listProducts()
    .subscribe(data=>{
      this.products=data;
    })
  }
  saveProduct(){
    if (this.product.id) {
      this.service.updateProduct(this.product).subscribe(data => {
        alert("El producto se modifico con exito");
        window.location.reload()
      })
    } else {
      this.service.createProduct(this.product).subscribe(data => {
        alert("El producto se agrego con exito");
        window.location.reload()
      })
    }
  }
  updateProduct(product:Product){
    this.product=product
  }
  deleteProduct(product:Product){
    this.service.deleteProduct(product.id).subscribe(data => {
      alert("El producto se elimino con exito");
      window.location.reload()
    })
    }
}
