import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ShoppingCart } from '../Model/shoppingCart'

@Injectable({
  providedIn: 'root'
})
export class ServiceService {

  constructor(private http:HttpClient) { }
  UrlShoppingCart = 'http://localhost:8080/shoppingCart';

  createShoppingCart(shoppingCart:ShoppingCart){
    return this.http.post<ShoppingCart>(this.UrlShoppingCart + "/addShoppingCart",shoppingCart);
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

}