package com.springbootexceptionhandlingwithaspect.app.service;

import com.springbootexceptionhandlingwithaspect.app.model.Order;
import com.springbootexceptionhandlingwithaspect.app.model.Payment;
import com.springbootexceptionhandlingwithaspect.app.repository.OrderRepository;
import com.springbootexceptionhandlingwithaspect.app.repository.PaymentRepository;
import com.springbootexceptionhandlingwithaspect.app.request.PaymentDTO;
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

    private final OrderRepository orderRepository;

    public PaymentService(PaymentRepository paymentRepository, OrderRepository orderRepository) {
        this.paymentRepository = paymentRepository;
        this.orderRepository = orderRepository;
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
    public Payment save(PaymentDTO paymentDTO) {
        LOG.info("PaymentService | save is called");

        Order order = orderRepository.getById(paymentDTO.getOrderId());
        Payment payment = new Payment();
        payment.setMoment(paymentDTO.getMoment());
        payment.setOrder(order);

        return paymentRepository.save(payment);
    }

    @Override
    public void saveAll(List<Payment> paymentList) {
        LOG.info("PaymentService | saveAll is called");
        paymentRepository.saveAll(paymentList);
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
    public Payment update(Long id, PaymentDTO paymentDTO) {
        LOG.info("OrderService | update is called");
        Optional<Payment> selectedPayment = paymentRepository.findById(id);

        Order order = orderRepository.getById(paymentDTO.getOrderId());

        if(selectedPayment.isPresent()) {
            Payment paymentUpdate = selectedPayment.get();
            paymentUpdate.setId(id);
            paymentUpdate.setMoment(paymentDTO.getMoment());
            paymentUpdate.setOrder(order);

            return paymentRepository.save(paymentUpdate);
        }

        return null;
    }
}
