package com.springbootexceptionhandlingwithaspect.app.service.impl;

import com.springbootexceptionhandlingwithaspect.app.model.Order;
import com.springbootexceptionhandlingwithaspect.app.model.Payment;

import java.util.List;

public interface IPaymentService {

    public List<Payment> getAll();
    public Payment findById(Long id);
    public Payment save(Payment payment);
    public void delete(Long id);
    public Payment update(Long id, Payment payment);
}
