package com.springbootexceptionhandlingwithaspect.app.response;

import com.springbootexceptionhandlingwithaspect.app.model.Order;
import com.springbootexceptionhandlingwithaspect.app.model.Product;
import lombok.Data;

@Data
public class OrderItemDTOResponse {
    private Order order;
    private Product product;
    private Integer quantity;
    private Double price;
}
