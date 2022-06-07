package com.nbouraoui.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	@RequestMapping("/hello")
	public String sayHello() {
		return "Hello World";
	}
}
