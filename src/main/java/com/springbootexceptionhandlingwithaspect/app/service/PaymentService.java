package com.springbootexceptionhandlingwithaspect.app.service;

import com.springbootexceptionhandlingwithaspect.app.model.Order;
import com.springbootexceptionhandlingwithaspect.app.model.Payment;
import com.springbootexceptionhandlingwithaspect.app.repository.OrderRepository;
import com.springbootexceptionhandlingwithaspect.app.repository.PaymentRepository;
import com.springbootexceptionhandlingwithaspect.app.service.impl.IPaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PaymentService implements IPaymentService {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public List<Payment> getAll() {
        LOG.info("PaymentService | getAll is called");
        return paymentRepository.findAll();
    }

    @Override
    public Payment findById(Long id) {
        LOG.info("PaymentService | findById is called");

        LOG.info("PaymentService | findById | order : " + paymentRepository.getById(id).toString());

        return paymentRepository.getById(id);
    }

    @Override
    public Payment save(Payment payment) {
        LOG.info("PaymentService | save is called");
        return paymentRepository.save(payment);
    }

    @Override
    public void delete(Long id) {
        LOG.info("PaymentService | delete is called");
        Optional<Payment> payment = paymentRepository.findById(id);
        if(payment.isPresent()) {
            Payment deletedPayment = payment.get();
            paymentRepository.delete(deletedPayment);
            LOG.info("PaymentService | delete | Payment deleted ");
        }
    }

    @Override
    public Payment update(Long id, Payment payment) {
        LOG.info("OrderService | update is called");
        Optional<Payment> selectedPayment = paymentRepository.findById(id);
        if(selectedPayment.isPresent()) {
            Payment paymentUpdate = selectedPayment.get();
            paymentUpdate.setId(id);
            paymentUpdate.setMoment(payment.getMoment());
            paymentUpdate.setOrder(payment.getOrder());

            return paymentRepository.save(paymentUpdate);
        }

        return null;
    }
}
