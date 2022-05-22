import { Component, OnInit } from '@angular/core';
import { ShoppingCart } from '../components/shopping_cart_component/Model/shoppingCart';
import { ServiceShoppingCart } from '../components/shopping_cart_component/Service/ServiceShoppingCart';

@Component({
  selector: 'app-mi-carrito',
  templateUrl: './mi-carrito.component.html',
  styleUrls: ['./mi-carrito.component.scss']
})
export class MiCarritoComponent implements OnInit {
miCarrito:ShoppingCart = new ShoppingCart();
  constructor(private serviceShopping: ServiceShoppingCart ) { 
    let id = localStorage.getItem("idCart");
    this.serviceShopping.getShoppingCartById(Number(id))
      .subscribe(data=>{
        this.miCarrito=data;
      })
  }

  ngOnInit(): void {
    let id = localStorage.getItem("idCart");
    this.serviceShopping.getShoppingCartById(Number(id))
      .subscribe(data=>{
        this.miCarrito=data;
      })
  }

  comprarCarrito(){
    let idClient: string = localStorage.getItem("idCliente");
    console.log(idClient)
    this.serviceShopping.buyCart(idClient,this.miCarrito)
      .subscribe(data=>{
        this.miCarrito=data;
      })
  }

}
