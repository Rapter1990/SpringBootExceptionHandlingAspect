package com.springbootexceptionhandlingwithaspect.app.response;

import com.springbootexceptionhandlingwithaspect.app.model.Order;
import lombok.Data;

import java.time.Instant;

@Data
public class PaymentDTOResponse {
    private Instant moment;
    private Order order;
}
