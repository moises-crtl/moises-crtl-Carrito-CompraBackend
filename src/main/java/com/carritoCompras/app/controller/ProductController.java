package com.carritoCompras.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.carritoCompras.app.model.Product;
import com.carritoCompras.app.service.ServiceProduct;
import com.carritoCompras.app.utils.Constan;


@RestController
public class ProductController {
	

	private ServiceProduct serviceProduct;
	
	
	@Autowired	
	public ProductController(ServiceProduct serviceProduct) {	
		this.serviceProduct = serviceProduct;
	}

	@RequestMapping(value = Constan.ENDPOINT_LIST_ALL_PRODUCT, method = RequestMethod.GET)
	public ResponseEntity<List<Product>> findAll(){
		List<Product> products = serviceProduct.findAll();
		if(products.isEmpty()) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.ok(products);
		}
	}
	
	@RequestMapping(value = Constan.ENDPOINT_LIST_FIND_ID_PRODUCT, method = RequestMethod.GET)
	public ResponseEntity<Product> viewIdProduct(@PathVariable("idProduct")int idProduct){
		Product viewIdProduct = serviceProduct.findById(idProduct);
		if (viewIdProduct == null) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(viewIdProduct);
		}
	}

	@RequestMapping(value = Constan.ENDPOINT_DELETE_FIND_ID_PRODUCT, method = RequestMethod.DELETE)
	public ResponseEntity<Product> deleteProduct(@PathVariable("idProduct")int idProduct){
		Product deleteProduct = serviceProduct.delete(idProduct);
		if (deleteProduct == null) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(deleteProduct);
		}
	}
	
	@RequestMapping(value = Constan.ENDPOINT_UPDATE_BY_IDPRODUCT, method = RequestMethod.PUT)
	public ResponseEntity<Product> updateProduct(@PathVariable("idProduct")int idProduct, 
			@RequestBody Product product){
		Product updateProuct = serviceProduct.update(product);
		if (updateProuct == null) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(updateProuct);
		}
	}

}
