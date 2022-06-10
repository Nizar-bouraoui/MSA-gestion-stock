package com.nbouraoui.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nbouraoui.entities.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByPhoneNumber(String phoneNumber);
}
