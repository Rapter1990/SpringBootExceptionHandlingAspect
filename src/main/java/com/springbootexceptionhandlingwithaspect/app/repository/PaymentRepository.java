package com.springbootexceptionhandlingwithaspect.app.repository;

import com.springbootexceptionhandlingwithaspect.app.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
