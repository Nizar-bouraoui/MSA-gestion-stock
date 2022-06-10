package com.nbouraoui.services;

import java.util.Random;

import org.springframework.stereotype.Service;
@Service
public class AuthenticationManager {
	
	public String generateConfirmationCode() {
		Random rnd = new Random();
		int n = 100000 + rnd.nextInt(900000);
		return String.valueOf(n);
	}

}
