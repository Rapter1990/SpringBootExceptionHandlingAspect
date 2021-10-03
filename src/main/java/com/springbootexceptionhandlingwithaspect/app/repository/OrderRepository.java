package com.springbootexceptionhandlingwithaspect.app.repository;

import com.springbootexceptionhandlingwithaspect.app.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
