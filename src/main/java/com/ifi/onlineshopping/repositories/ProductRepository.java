package com.ifi.onlineshopping.repositories;

import com.ifi.onlineshopping.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findProductByNameContaining(String name);
}
