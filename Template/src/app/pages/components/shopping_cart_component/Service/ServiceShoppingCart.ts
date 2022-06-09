import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ShoppingCart } from '../Model/shoppingCart'
import { Product } from '../../product_client/Model/Product';

@Injectable({
  providedIn: 'root'
})
export class ServiceShoppingCart {

  constructor(private http:HttpClient) { }
  UrlShoppingCart = 'http://ec2-52-91-233-117.compute-1.amazonaws.com:8080/comercialApp/shoppingCart';
  UrlClient = 'http://ec2-52-91-233-117.compute-1.amazonaws.com:8080/comercialApp/client';

  createShoppingCart(idClient: string, shoppingCart:ShoppingCart){
    return this.http.post<ShoppingCart>(this.UrlShoppingCart + "/addShoppingCart/" + idClient,shoppingCart);
  }
  listShoppingCarts(){
    return this.http.get<ShoppingCart[]>(this.UrlShoppingCart+"/listShoppingCart");
  }
  updateShoppingCart(shoppingCart:ShoppingCart){
    return this.http.put<ShoppingCart>(this.UrlShoppingCart+"/editShoppingCart",shoppingCart);
  }
  deleteShoppingCart(id:number){
    return this.http.delete<ShoppingCart>(this.UrlShoppingCart+"/deleteShoppingCart/" + id);
  }
  addProductShoppingCart(product:Product, idCart:number){
    return this.http.post<ShoppingCart>(this.UrlShoppingCart + "/addProductToCart/" + idCart,product);
  }
  getShoppingCartById(idCart: number){
    return this.http.get<ShoppingCart>(this.UrlShoppingCart+"/getCart/" + idCart);
  }
  buyCart(idClient: string,shoppingCart:ShoppingCart){
    return this.http.post<ShoppingCart>(this.UrlClient + "/buyCart/" + idClient,shoppingCart);
  }

}