package com.springbootexceptionhandlingwithaspect.app.service;

import com.springbootexceptionhandlingwithaspect.app.model.*;
import com.springbootexceptionhandlingwithaspect.app.repository.*;
import com.springbootexceptionhandlingwithaspect.app.request.OrderDTO;
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

    private final UserRepository userRepository;

    private final PaymentRepository paymentRepository;

    private final OrderItemRepository orderItemRepository;

    public OrderService(OrderRepository orderRepository,UserRepository userRepository,
                        PaymentRepository paymentRepository,OrderItemRepository orderItemRepository ) {
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
        this.paymentRepository = paymentRepository;
        this.orderItemRepository = orderItemRepository;
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
    public Order save(OrderDTO orderDTO) {
        LOG.info("OrderService | save is called");

        User user = userRepository.getById(orderDTO.getUserId());
        Payment payment = paymentRepository.getById(orderDTO.getPaymentId());
        OrderItem orderItem = orderItemRepository.getById(orderDTO.getItemId());

        Order order = new Order();
        order.setOrderStatus(orderDTO.getOrderStatus());
        order.setMoment(orderDTO.getMoment());
        order.getUsers().add(user);
        order.getItems().add(orderItem);
        order.setPayment(payment);

        return orderRepository.save(order);
    }

    @Override
    public void saveAll(List<Order> orderList) {
        LOG.info("OrderService | saveAll is called");
        orderRepository.saveAll(orderList);
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
    public Order update(Long id, OrderDTO orderDTO) {
        LOG.info("OrderService | update is called");
        Optional<Order> selectedOrder = orderRepository.findById(id);

        User user = userRepository.getById(orderDTO.getUserId());
        Payment payment = paymentRepository.getById(orderDTO.getPaymentId());
        OrderItem orderItem = orderItemRepository.getById(orderDTO.getItemId());

        if(selectedOrder.isPresent()) {
            Order orderUpdate = selectedOrder.get();
            orderUpdate.setId(id);
            orderUpdate.setOrderStatus(orderDTO.getOrderStatus());
            orderUpdate.setMoment(orderDTO.getMoment());
            orderUpdate.getUsers().add(user);
            orderUpdate.getItems().add(orderItem);
            orderUpdate.setPayment(payment);

            return orderRepository.save(orderUpdate);
        }

        return null;
    }
}
