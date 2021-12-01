package com.carritoCompras.app.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carritoCompras.app.model.Product;


@Service
public class ServiceProductImp implements ServiceProduct{

	public List<Product> products;
	

	private ServiceProduct serviceProduct;
	
	
	public List<Product> ServicioBean() {
		products = new ArrayList<>();
		products.add(new Product(1, "Lata de Coca-Cola", "image/", 20.0, 8));
		products.add(new Product(2, "Lata de Merengue", "image/", 20.0, 8));
		products.add(new Product(3, "Lata de Cola Naranja", "image/", 15.5, 8));
		products.add(new Product(4, "Botella de Agua", "image/", 10, 8));
		products.add(new Product(5, "Bolsa de Patatas", "image/", 32, 8));
		return products;
	}
	
	
	@Override
	public List<Product> findAll() {
		products = ServicioBean().stream().collect(Collectors.toList());
		return products;
	}

	@Override
	public Product findById(int idProduct) {
		Product product = new Product();
		product = ServicioBean().stream().filter(f -> 
		f.getIdProduct() == idProduct).collect(Collectors.toList()).get(0);
		return product;
	}


	@Override
	public Product delete(int idProduct) {
		Product product = new Product();
		product = ServicioBean().stream().filter(f -> 
		f.getIdProduct() == idProduct).collect(Collectors.toList()).get(0);		
		if(product == null) {
			return null;
		}else {			
//			product = null;
			System.gc();
			return product;	
			
		}
		
	}


	@Override
	public Product update(Product product) {
		Product updateProduct = serviceProduct.findById(product.getIdProduct());
		if(updateProduct == null) {
			return null;
		}else {
			updateProduct.setIdProduct(product.getIdProduct());
			updateProduct.setName(product.getName());
			updateProduct.setImage(product.getImage());
			updateProduct.setPrice(product.getPrice());
			updateProduct.setStock(product.getStock());
			return serviceProduct.update(updateProduct);
		}
	}

}
