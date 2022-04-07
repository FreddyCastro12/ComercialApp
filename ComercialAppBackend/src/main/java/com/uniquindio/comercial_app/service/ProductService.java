package com.uniquindio.comercial_app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uniquindio.comercial_app.interfaceService.IProductService;
import com.uniquindio.comercial_app.interfaces.IProduct;
import com.uniquindio.comercial_app.modelo.Product;

@Service
public class ProductService implements IProductService{
	
	@Autowired
	private IProduct dataProduct;

	@Override
	public Product addProduct(Product product) {
		return dataProduct.save(product);
	}

	@Override
	public List<Product> listProducts() {
		return (List<Product>) dataProduct.findAll();
	}

	@Override
	public Product editProduct(Product product) {
		return dataProduct.save(product);
	}

	@Override
	public Product deleteProduct(Integer id) {
		Product product = dataProduct.findById(id).get();
		if (product!=null) {
			dataProduct.delete(product);
		}
		return product;
	}
}
