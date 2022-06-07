package com.nbouraoui.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.nbouraoui.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
