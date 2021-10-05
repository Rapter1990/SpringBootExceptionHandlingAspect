package com.springbootexceptionhandlingwithaspect.app.service.impl;

import com.springbootexceptionhandlingwithaspect.app.model.OrderItem;
import com.springbootexceptionhandlingwithaspect.app.request.OrderItemDTO;

import java.util.List;

public interface IOrderItemService {

    public List<OrderItem> getAll();
    public OrderItem findById(Long id);
    public OrderItem save(OrderItemDTO orderItemDTO);
    public void delete(Long id);
    public OrderItem update(Long id, OrderItemDTO orderItemDTO);
    public void saveAll(List<OrderItem> orderItemList);
}
