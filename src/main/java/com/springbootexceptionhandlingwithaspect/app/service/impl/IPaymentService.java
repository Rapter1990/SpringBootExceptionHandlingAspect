package com.springbootexceptionhandlingwithaspect.app.service.impl;

import com.springbootexceptionhandlingwithaspect.app.model.Order;
import com.springbootexceptionhandlingwithaspect.app.model.Payment;
import com.springbootexceptionhandlingwithaspect.app.request.PaymentDTO;

import java.util.List;

public interface IPaymentService {

    public List<Payment> getAll();
    public Payment findById(Long id);
    public Payment save(PaymentDTO paymentDTO);
    public void delete(Long id);
    public Payment update(Long id, PaymentDTO paymentDTO);
    public void saveAll(List<Payment> paymentList);
}
