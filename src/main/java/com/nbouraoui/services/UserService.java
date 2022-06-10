package com.nbouraoui.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nbouraoui.entities.User;
import com.nbouraoui.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;

	
	public List<User> findAll() {
		return userRepository.findAll();
	}

	
	public User findById(Long id) {
		return userRepository.findById(id).get();
	}

	
	public User save(User object) {
		return userRepository.save(object);
	}

	
	public void delete(User object) {
		userRepository.delete(object);
	}

	
	public void deleteById(Long id) {
		userRepository.deleteById(id);
		
	}

	
	public User findByPhoneNumber(String phoneNumber) {
		return userRepository.findByPhoneNumber(phoneNumber);
	}
	
	public boolean checkUserExtistenceByPhoneNumber(User user) {
		if (findByPhoneNumber(user.getPhoneNumber())!= null) {
			return true;
		}
		return false;
	}
	
	

}
