package com.uniquindio.comercial_app.interfaceService;

import java.util.List;

import com.uniquindio.comercial_app.modelo.Product;

public interface IProductService {
	
	public Product addProduct(Product product);

	public List<Product> listProducts();

	public Product editProduct(Product product);

	public Product deleteProduct(Integer id);
	
}
