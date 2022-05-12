package com.uniquindio.comercial_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uniquindio.comercial_app.interfaceService.IShoppingCartService;
import com.uniquindio.comercial_app.modelo.Product;
import com.uniquindio.comercial_app.modelo.ShoppingCart;

@RestController
@RequestMapping("/shoppingCart")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class ShoppingCartController {

	@Autowired
	private IShoppingCartService serviceCarts;

	// Create cart
	@PostMapping("/addShoppingCart")
	public ShoppingCart addShoppingCart(@RequestBody ShoppingCart shoppingCart) {
		return serviceCarts.addShoppingCart(shoppingCart);
	}

	// Add product to cart
	@PostMapping("/addProductToCart/{idCart}")
	public ShoppingCart addProductToCart(@RequestBody Product product, @PathVariable Integer idCart) {
		ShoppingCart shoppingCart = serviceCarts.findById(idCart);
		List<Product> products = shoppingCart.getProducts();
		products.add(product);
		shoppingCart.setProducts(products);
		return serviceCarts.addShoppingCart(shoppingCart);
	}
	
}
