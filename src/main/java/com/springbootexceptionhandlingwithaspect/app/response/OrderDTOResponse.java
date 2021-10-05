package com.springbootexceptionhandlingwithaspect.app.response;

import com.springbootexceptionhandlingwithaspect.app.model.OrderItem;
import com.springbootexceptionhandlingwithaspect.app.model.Payment;
import com.springbootexceptionhandlingwithaspect.app.model.User;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Data
public class OrderDTOResponse {
    private Instant moment;
    private Integer orderStatus;
    private List<User> users;
    private Payment payment;
    private List<OrderItem> orderItems;
}
