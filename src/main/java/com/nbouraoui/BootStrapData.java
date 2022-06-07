package com.nbouraoui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nbouraoui.entities.Product;
import com.nbouraoui.repositories.ProductRepository;
@Component
public class BootStrapData implements CommandLineRunner {
	
	@Autowired
	ProductRepository productRepository;

	@Override
	public void run(String... args) throws Exception {
		Product p1 = new Product();
		p1.setName("watch");
		p1.setPrice(200.00);
		p1.setDescription("water proof");
		productRepository.save(p1);
		
	}

}
