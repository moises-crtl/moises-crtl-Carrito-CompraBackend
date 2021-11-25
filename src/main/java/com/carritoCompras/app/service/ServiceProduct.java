package com.carritoCompras.app.service;


import java.util.List;

import com.carritoCompras.app.model.Product;


public interface ServiceProduct {
	
	public List<Product> findAll();
	public Product findById(int idProduct);
	public Product delete(int idProduct);
	public Product update(Product product);

}
