package com.springbootexceptionhandlingwithaspect.app.request;

import lombok.Data;

@Data
public class OrderItemDTO {
    private Long id;
    private Long orderId;
    private Long productId;
    private int quantity;
    private double price;
}
