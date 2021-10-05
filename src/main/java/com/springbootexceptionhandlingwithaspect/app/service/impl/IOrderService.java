package com.springbootexceptionhandlingwithaspect.app.service.impl;

import com.springbootexceptionhandlingwithaspect.app.model.Order;
import com.springbootexceptionhandlingwithaspect.app.request.OrderDTO;

import java.util.List;

public interface IOrderService {

    public List<Order> getAll();
    public Order findById(Long id);
    public Order save(OrderDTO orderDTO);
    public void delete(Long id);
    public Order update(Long id, OrderDTO orderDTO);
    public void saveAll(List<Order> orderList);

}
