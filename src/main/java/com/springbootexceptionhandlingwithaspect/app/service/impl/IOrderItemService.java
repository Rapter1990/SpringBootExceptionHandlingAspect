package com.springbootexceptionhandlingwithaspect.app.service.impl;

import com.springbootexceptionhandlingwithaspect.app.model.OrderItem;

import java.util.List;

public interface IOrderItemService {

    public List<OrderItem> getAll();
    public OrderItem findById(Long id);
    public OrderItem save(OrderItem orderItem);
    public void delete(Long id);
    public OrderItem update(Long id, OrderItem orderItem);
    public void saveAll(List<OrderItem> orderItemList);
}
