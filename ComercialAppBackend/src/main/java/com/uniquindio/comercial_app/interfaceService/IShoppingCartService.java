package com.uniquindio.comercial_app.interfaceService;

import com.uniquindio.comercial_app.modelo.Service;
import com.uniquindio.comercial_app.modelo.ShoppingCart;

public interface IShoppingCartService {

	public ShoppingCart addShoppingCart(ShoppingCart shoppingCart);

	public ShoppingCart findById(Integer idCart);

}
