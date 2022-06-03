package com.uniquindio.comercial_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uniquindio.comercial_app.interfaceService.IClientService;
import com.uniquindio.comercial_app.interfaceService.IShoppingCartService;
import com.uniquindio.comercial_app.modelo.Client;
import com.uniquindio.comercial_app.modelo.Product;
import com.uniquindio.comercial_app.modelo.ShoppingCart;

@RestController
@RequestMapping("/shoppingCart")
@CrossOrigin
public class ShoppingCartController {

	@Autowired
	private IShoppingCartService serviceCarts;
	
	@Autowired
	private IClientService serviceClient;

	// Create cart
	@PostMapping("/addShoppingCart/{idClient}")
	public ShoppingCart addShoppingCart(@RequestBody ShoppingCart shoppingCart, @PathVariable Integer idClient) {
		Client client = new Client();
		client = serviceClient.findById(idClient);
		client.getShoppingCarts().add(shoppingCart);
		ShoppingCart carrito = serviceCarts.addShoppingCart(shoppingCart);
		serviceClient.addClient(client);
		return carrito;
	}

	// Add product to cart
	@PostMapping("/addProductToCart/{idCart}")
	public ShoppingCart addProductToCart(@RequestBody Product product, @PathVariable Integer idCart) {
		ShoppingCart shoppingCart = new ShoppingCart();
		try {
			shoppingCart = serviceCarts.findById(idCart);
			List<Product> products = shoppingCart.getProducts();
			boolean isContain = false;
			boolean centinel = false;
			for (int i = 0; i <= shoppingCart.getProducts().size() -1 && centinel == false; i++) {
				if (products.get(i).getId() == product.getId()) {
					Product product2 = shoppingCart.getProducts().get(i);
					if (product2.getId() == product.getId()) {
						if (product.getAmount() == null) {
							product2.setAmount(1);
							shoppingCart.getProducts().set(i, product2);
							shoppingCart.setCost(shoppingCart.getCost() + product2.getCost());
							isContain = true;
							centinel = true;
						}else {
							product2.setAmount(product2.getAmount() + 1);
							shoppingCart.getProducts().set(i, product2);
							shoppingCart.setCost(shoppingCart.getCost() + product2.getCost());
							isContain = true;
							centinel = true;
						}
					}
				}
			}
			if (isContain == false) {
				products.add(product);
				shoppingCart.setCost(shoppingCart.getCost() + product.getCost());
				shoppingCart.setProducts(products);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error agregando el producto a el carrito");
		}
		return serviceCarts.addShoppingCart(shoppingCart);
	}

	// get cart by id
	@GetMapping("/getCart/{idCart}")
	public ShoppingCart addShoppingCart(@PathVariable Integer idCart) {
		ShoppingCart cart = new ShoppingCart();
		try {
			cart = serviceCarts.findById(idCart);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("product not found");
		}
		return cart;
	}

}
