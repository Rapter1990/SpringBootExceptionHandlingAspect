package com.springbootexceptionhandlingwithaspect.app.service;

import com.springbootexceptionhandlingwithaspect.app.model.Category;
import com.springbootexceptionhandlingwithaspect.app.model.Order;
import com.springbootexceptionhandlingwithaspect.app.repository.OrderRepository;
import com.springbootexceptionhandlingwithaspect.app.repository.ProductRepository;
import com.springbootexceptionhandlingwithaspect.app.service.impl.IOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrderService implements IOrderService {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> getAll() {
        LOG.info("OrderService | getAll is called");
        return orderRepository.findAll();
    }

    @Override
    public Order findById(Long id) {
        LOG.info("OrderService | findById is called");

        LOG.info("OrderService | findById | order : " + orderRepository.getById(id).toString());

        return orderRepository.getById(id);
    }

    @Override
    public Order save(Order order) {
        LOG.info("OrderService | save is called");
        return orderRepository.save(order);
    }

    @Override
    public void delete(Long id) {
        LOG.info("OrderService | delete is called");
        Optional<Order> order = orderRepository.findById(id);
        if(order.isPresent()) {
            Order deletedOrder = order.get();
            orderRepository.delete(deletedOrder);
            LOG.info("OrderService | delete | Order deleted ");
        }
    }

    @Override
    public Order update(Long id, Order order) {
        LOG.info("OrderService | update is called");
        Optional<Order> selectedOrder = orderRepository.findById(id);
        if(selectedOrder.isPresent()) {
            Order orderUpdate = selectedOrder.get();
            orderUpdate.setId(id);
            orderUpdate.setItems(order.getItems());
            orderUpdate.setMoment(order.getMoment());
            orderUpdate.setOrderStatus(order.getOrderStatus());
            orderUpdate.setUsers(order.getUsers());
            orderUpdate.setPayment(order.getPayment());

            return orderRepository.save(orderUpdate);
        }

        return null;
    }
}
