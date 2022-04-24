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
  constructor(private router:Router, private service:ServiceService) { }

  ngOnInit(): void {
  }
  saveProduct(){
    console.log("entra")
    console.log(this.product)
    this.service.createProduct(this.product).subscribe(data => {
      alert("El producto se agrego con exito");
    })
  }
}
