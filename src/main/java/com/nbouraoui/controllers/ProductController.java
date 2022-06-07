package com.nbouraoui.controllers;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nbouraoui.entities.Product;
import com.nbouraoui.entities.Response;
import com.nbouraoui.services.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	@Autowired
	ProductService productService;

	@PostMapping
	public ResponseEntity<Response> addProduct(@RequestBody Product product){
		return ResponseEntity.ok(
				Response.builder()
				.timeStamp(LocalDateTime.now())
				.data(Map.of("product",productService.addProduct(product)))
				.message("product saved successfully")
				.status(HttpStatus.CREATED)
				.statusCode(HttpStatus.CREATED.value())
				.build()
				);
	}
	@PutMapping
	public ResponseEntity<Response> updateProduct(@RequestBody Product product){
		return ResponseEntity.ok(
				Response.builder()
				.timeStamp(LocalDateTime.now())
				.data(Map.of("product",productService.updateProduct(product)))
				.message("product updated successfully")
				.status(HttpStatus.OK)
				.statusCode(HttpStatus.OK.value())
				.build()
				);
	}
	@GetMapping
	public ResponseEntity<Response> findAllProduct(){
		return ResponseEntity.ok(
				Response.builder()
				.timeStamp(LocalDateTime.now())
				.data(Map.of("product",productService.findAllProduct()))
				.message("products retrieved successfully")
				.status(HttpStatus.OK)
				.statusCode(HttpStatus.OK.value())
				.build()
				);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Response> findProductById(@PathVariable int id){
		return ResponseEntity.ok(
				Response.builder()
				.timeStamp(LocalDateTime.now())
				.data(Map.of("product",productService.findProductbyId(id)))
				.message("product retrieved successfully")
				.status(HttpStatus.OK)
				.statusCode(HttpStatus.OK.value())
				.build()
				);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Response> findAllProduct(@PathVariable int id){
		return ResponseEntity.ok(
				Response.builder()
				.timeStamp(LocalDateTime.now())
				.data(Map.of("product id : ",id))
				.message("product deleted successfully")
				.status(HttpStatus.OK)
				.statusCode(HttpStatus.OK.value())
				.build()
				);
	}
}
