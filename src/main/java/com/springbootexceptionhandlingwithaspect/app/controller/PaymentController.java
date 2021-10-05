package com.springbootexceptionhandlingwithaspect.app.controller;

import com.springbootexceptionhandlingwithaspect.app.model.Payment;
import com.springbootexceptionhandlingwithaspect.app.request.PaymentDTO;
import com.springbootexceptionhandlingwithaspect.app.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payment/v1")
public class PaymentController {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    // http://localhost:8082/api/payment/v1/payments
    @GetMapping("/payments")
    public List<PaymentDTO> getAll() {
        LOG.info("PaymentController | getAll is called");
        return paymentService.getAll();
    }

    // http://localhost:8082/api/payment/v1/payment/add
    @PostMapping("/payment/add")
    public Payment createPayment(@RequestBody PaymentDTO payment) {
        LOG.info("PaymentController | createOrder is called");
        return paymentService.save(payment);
    }

    // http://localhost:8082/api/payment/v1/payment/getPaymentById/{id}
    @GetMapping("/payment/getPaymentById/{id}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable long id) {
        LOG.info("PaymentController | getPaymentById is called");
        Payment payment = paymentService.findById(id);
        return ResponseEntity.ok(payment);
    }

    // http://localhost:8082/api/payment/v1/payment/update?id={id}
    @PutMapping("/payment/update")
    public ResponseEntity<Payment> updatePayment(@RequestParam long id, @RequestBody PaymentDTO payment) {
        LOG.info("PaymentController | updatePayment is called");
        Payment updatedPayment = paymentService.update(id,payment);
        return ResponseEntity.ok(updatedPayment);
    }

    // http://localhost:8082/api/payment/v1/payment/delete/{id}
    @DeleteMapping("/payment/delete/{id}")
    public void deletePayment(@PathVariable long id) {
        LOG.info("PaymentController | deletePayment is called");
        paymentService.delete(id);
    }
}
