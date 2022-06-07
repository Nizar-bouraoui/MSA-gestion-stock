package com.nbouraoui.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.nbouraoui.entities.Product;
import com.nbouraoui.repositories.ProductRepository;

public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public Product addProduct(Product product) {
		return productRepository.save(product);
	}
	
	public Product updateProduct(Product product) {
		Product existingProdduct = productRepository.findById(product.getId()).get();
		if (existingProdduct != null) {
			return productRepository.save(product);
		}
		return null;
	}
	
	public List<Product> findAllProduct(){
		return productRepository.findAll();
	}
	
	public Product findProductbyId(int id) {
		return productRepository.findById(id).get();
	}
	
	public void deleteProductById(int id) {
		productRepository.deleteById(id);
	}

}
