package com.carritoCompras.app.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
	
	private int idProduct;
	private String name;
	private String image;
	private double price;
	private int stock;	
	

}
