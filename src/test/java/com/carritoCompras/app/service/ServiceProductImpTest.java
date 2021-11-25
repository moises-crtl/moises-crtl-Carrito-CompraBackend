package com.carritoCompras.app.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import com.carritoCompras.app.model.Product;


class ServiceProductImpTest {
	
	@Mock
	private ServiceProductImp serviceProductImp;
	
	@Autowired
	private ServiceProduct serviceProduct;
	
	

	@Test
	void findAllTest() {
		serviceProduct = new ServiceProductImp();
		List<Product> currentProducts = serviceProduct.findAll();		
		assertThat(currentProducts).size().isGreaterThan(0);
		
	}
	
	@Test
	void findByIdTest() {
		serviceProduct = new ServiceProductImp();
		int idProduct = 1;
		Product findById = serviceProduct.findById(idProduct);
		assertThat(findById.getIdProduct()).isEqualByComparingTo(idProduct);
	}

	@Test
	public void deleteTest() {
		serviceProduct = new ServiceProductImp();
		int idProduct = 1;
		Product deleteProduct = serviceProduct.delete(idProduct);
		assertThat(deleteProduct.getIdProduct()).isEqualTo(idProduct);
	}
	
	@Test
	public void updateTest() {
		serviceProduct = new ServiceProductImp();
		Product cola = Product.builder()
				.idProduct(1)
				.name("Lata Coca-Cola")
				.image("image/")
				.price(20.0)
				.stock(7)
				.build();
		cola.setIdProduct(1);
		when(serviceProduct.update(cola)).thenReturn(cola);
		assertThat(cola.getName().compareTo("Lata Coca-Cola"));
	}
}
