package com.springbootexceptionhandlingwithaspect.app.repository;

import com.springbootexceptionhandlingwithaspect.app.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
