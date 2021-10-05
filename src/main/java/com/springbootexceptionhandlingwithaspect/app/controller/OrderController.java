package com.springbootexceptionhandlingwithaspect.app.controller;

import com.springbootexceptionhandlingwithaspect.app.model.Order;
import com.springbootexceptionhandlingwithaspect.app.request.OrderDTO;
import com.springbootexceptionhandlingwithaspect.app.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order/v1")
public class OrderController {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    /**
     * {
     *     "moment": "2021-06-20T19:53:07Z",
     *     "orderStatus": 3,
     *     "userId" : 1,
     *     "paymentId" : 1,
     *     "itemId" :1
     * }
     */

    // http://localhost:8082/api/order/v1/orders
    @GetMapping("/orders")
    public List<Order> getAll() {
        LOG.info("OrderController | getAll is called");
        return orderService.getAll();
    }

    // http://localhost:8082/api/order/v1/order/add
    @PostMapping("/order/add")
    public Order createOrder(@RequestBody OrderDTO order) {
        LOG.info("OrderController | createOrder is called");
        return orderService.save(order);
    }

    // http://localhost:8082/api/order/v1/order/getOrderById/{id}
    @GetMapping("/order/getOrderById/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable long id) {
        LOG.info("OrderController | getOrderById is called");
        Order order = orderService.findById(id);
        return ResponseEntity.ok(order);
    }

    // http://localhost:8082/api/order/v1/order/update?id={id}
    @PutMapping("/order/update")
    public ResponseEntity<Order> updateOrder(@RequestParam long id, @RequestBody OrderDTO order) {
        LOG.info("OrderController | updateOrder is called");
        Order updatedOrder = orderService.update(id,order);
        return ResponseEntity.ok(updatedOrder);
    }

    // http://localhost:8082/api/order/v1/order/delete/{id}
    @DeleteMapping("/order/delete/{id}")
    public void deleteProduct(@PathVariable long id) {
        LOG.info("ProductController | deleteProduct is called");
        orderService.delete(id);
    }
}
