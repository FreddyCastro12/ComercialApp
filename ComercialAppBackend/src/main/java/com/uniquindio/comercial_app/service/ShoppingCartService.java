package com.uniquindio.comercial_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uniquindio.comercial_app.interfaceService.IShoppingCartService;
import com.uniquindio.comercial_app.interfaces.IShoppingCart;
import com.uniquindio.comercial_app.modelo.ShoppingCart;

@Service
public class ShoppingCartService implements IShoppingCartService{
	
	@Autowired
	private IShoppingCart dataShoppingCart;

	@Override
	public ShoppingCart addShoppingCart(ShoppingCart shoppingCart) {
		return dataShoppingCart.save(shoppingCart);
	}

	@Override
	public ShoppingCart findById(Integer idCart) {
		return dataShoppingCart.findById(idCart).get();
	}
}
