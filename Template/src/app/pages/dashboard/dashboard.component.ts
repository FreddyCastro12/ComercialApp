import { Component, OnChanges, OnInit, SimpleChanges } from '@angular/core';
import Chart from 'chart.js';

// core components
import {
  chartOptions,
  parseOptions,
  chartExample1,
  chartExample2
} from "../../variables/charts";
import { Product } from '../components/product_client/Model/Product';
import { ServiceService } from '../components/product_client/Service/service.service';
import { ShoppingCart } from '../components/shopping_cart_component/Model/shoppingCart';
import { ServiceShoppingCart } from '../components/shopping_cart_component/Service/ServiceShoppingCart';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {
  products: Product[];
  productsTemps: Product[] = [];
  shoppingCarts: ShoppingCart = new ShoppingCart();
  public datasets: any;
  public data: any;
  public salesChart;
  public clicked: boolean = true;
  public clicked1: boolean = false;

  constructor(private service:ServiceService, private serviceShopping: ServiceShoppingCart) { }

  ngOnInit() {
    this.service.listProducts()
    .subscribe(data=>{
      this.products=data;
    })

    this.datasets = [
      [0, 20, 10, 30, 15, 40, 20, 60, 60],
      [0, 20, 5, 25, 10, 30, 15, 40, 40]
    ];
    this.data = this.datasets[0];


    var chartOrders = document.getElementById('chart-orders');

    parseOptions(Chart, chartOptions());


    var ordersChart = new Chart(chartOrders, {
      type: 'bar',
      options: chartExample2.options,
      data: chartExample2.data
    });

    var chartSales = document.getElementById('chart-sales');

    this.salesChart = new Chart(chartSales, {
			type: 'line',
			options: chartExample1.options,
			data: chartExample1.data
		});
  }
  
  updateListProducts(){
    let word = localStorage.getItem("findWord")
    alert(word)
    this.service.listProductsByWord(word)
    .subscribe(data=>{
      this.products=data;
    })
  }

  public updateOptions() {
    this.salesChart.data.datasets[0].data = this.data;
    this.salesChart.update();
  }

  buyProduct(product: Product){
    alert("comprado" + product.name)
    if(this.shoppingCarts.id==null){
      this.productsTemps.push(product);
      this.shoppingCarts.products = this.productsTemps;
      this.shoppingCarts.cost=product.cost;
      this.shoppingCarts.state = "Sin confirmar";
      console.log("sin" + this.shoppingCarts)
      this.serviceShopping.createShoppingCart(this.shoppingCarts)
      .subscribe(data=>{
        this.shoppingCarts=data;
        console.log("crea" + this.shoppingCarts.id)
      })
    } else{
      console.log("con" + this.shoppingCarts)
      this.shoppingCarts.cost = this.shoppingCarts.cost + product.cost;
      this.serviceShopping.addProductShoppingCart(product, this.shoppingCarts.id)
      .subscribe(data=>{
        this.shoppingCarts=data;
        console.log("agrega" + this.shoppingCarts)
        window.location.reload();
      })
    }
  }

}
