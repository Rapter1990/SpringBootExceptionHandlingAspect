package com.springbootexceptionhandlingwithaspect.app.service.impl;

import com.springbootexceptionhandlingwithaspect.app.model.Order;
import com.springbootexceptionhandlingwithaspect.app.model.OrderItem;

import java.util.List;

public interface IOrderService {

    public List<Order> getAll();
    public Order findById(Long id);
    public Order save(Order order);
    public void delete(Long id);
    public Order update(Long id, Order order);
    public void saveAll(List<Order> orderList);
}
