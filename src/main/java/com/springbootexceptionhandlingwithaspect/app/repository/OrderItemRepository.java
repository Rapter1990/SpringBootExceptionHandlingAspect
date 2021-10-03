package com.springbootexceptionhandlingwithaspect.app.repository;

import com.springbootexceptionhandlingwithaspect.app.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
