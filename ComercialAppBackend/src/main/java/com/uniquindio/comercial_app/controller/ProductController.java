package com.uniquindio.comercial_app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uniquindio.comercial_app.interfaceService.IProductService;
import com.uniquindio.comercial_app.modelo.Product;

@RestController
@RequestMapping("/product")
@CrossOrigin
public class ProductController {

	@Autowired
	private IProductService serviceProduct;

	// Create product
	@PostMapping("/addProduct")
	public Product addProduct(@RequestBody Product product) {
		if(validateProduct(product)) {
			String name = getNameOfPath(product.getImagen());
			product.setImagen(name);
			return serviceProduct.addProduct(product);
		}else {
			return null;
		}
	}

	// List products
	@GetMapping("/listProducts")
	public List<Product> listProducts() {
		return serviceProduct.listProducts();
	}

	// Edit product
	@PutMapping(path = { "/editProduct" })
	public Product editProduct(@RequestBody Product product) {
		if(validateProduct(product)) {
			String name = getNameOfPath(product.getImagen());
			product.setImagen(name);
			return serviceProduct.editProduct(product);
		}else {
			return null;
		}
	}

	// Delete product
	@DeleteMapping(path = { "/deleteProduct/{idProduct}" })
	public Product deleteProduct(@PathVariable("idProduct") Integer idProduct) {
		return serviceProduct.deleteProduct(idProduct);
	}
	
	// List products by word
	@GetMapping("/listProducts/{wordProduct}")
	public List<Product> listProductsbyWord(@PathVariable("wordProduct") String word) {
		List<Product> products = listProducts();
		List<Product> productsByWord = new ArrayList<>();
		for (Product product : products) {
			if (product.getName().contains(word)) {
				productsByWord.add(product);
			}
		}
		return productsByWord;
	}
	
	public String getNameOfPath(String path) {
		String name="";
		int find = path.lastIndexOf(92);
		name = path.substring(find+1,path.length());
		return name;
	}
	
	public boolean validateProduct(Product product) {
		if(product.getAmount() < 0 
				|| product.getCost() < 0 
				|| product.getDescription() == "" 
				|| product.getLocal() == null 
				|| product.getName() == "")
		{
			return false;
		}
		return true;
	}
}
