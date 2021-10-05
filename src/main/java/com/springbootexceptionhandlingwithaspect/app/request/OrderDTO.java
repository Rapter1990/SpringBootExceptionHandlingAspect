package com.springbootexceptionhandlingwithaspect.app.request;

import lombok.Data;

import java.time.Instant;

@Data
public class OrderDTO {

    private Instant moment;
    private int orderStatus;
    private Long userId;
    private Long paymentId;
    private Long itemId;
}
