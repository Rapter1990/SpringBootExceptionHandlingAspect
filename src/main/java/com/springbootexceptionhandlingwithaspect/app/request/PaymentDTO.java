package com.springbootexceptionhandlingwithaspect.app.request;

import com.springbootexceptionhandlingwithaspect.app.model.Order;
import lombok.Data;

import java.time.Instant;

@Data
public class PaymentDTO {
    private Long id;
    private Instant moment;
    private Long orderId;
}
