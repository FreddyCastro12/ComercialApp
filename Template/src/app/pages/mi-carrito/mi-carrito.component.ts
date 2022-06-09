import { Component, OnInit } from '@angular/core';
import { Client } from '../components/client_component/Model/Client';
import { ShoppingCart } from '../components/shopping_cart_component/Model/shoppingCart';
import { ServiceShoppingCart } from '../components/shopping_cart_component/Service/ServiceShoppingCart';
import { ServiceService } from 'src/app/pages/components/client_component/Service/service.service';
import { windowWhen } from 'rxjs';

@Component({
  selector: 'app-mi-carrito',
  templateUrl: './mi-carrito.component.html',
  styleUrls: ['./mi-carrito.component.scss']
})
export class MiCarritoComponent implements OnInit {
  miCarrito: ShoppingCart = new ShoppingCart();
  client: Client = new Client;
  constructor(private serviceShopping: ServiceShoppingCart, private serviceClient: ServiceService) {
    let id = localStorage.getItem("idCart");
    this.serviceShopping.getShoppingCartById(Number(id))
      .subscribe(data => {
        this.miCarrito = data;
      })
  }

  ngOnInit(): void {
    let id = localStorage.getItem("idCart");
    this.serviceShopping.getShoppingCartById(Number(id))
      .subscribe(data => {
        this.miCarrito = data;
      })
  }

  comprarCarrito() {
    let idClient: string = localStorage.getItem("idClient");
    console.log(idClient)
    this.serviceShopping.buyCart(idClient, this.miCarrito)
      .subscribe(data => {
        this.miCarrito = data;
      })
    this.serviceClient.getClient(Number(idClient))
      .subscribe(data => {
        this.client = data;
        localStorage.setItem("Amount", this.client.amount + "")
      })
    window.location.reload();
  }

}
