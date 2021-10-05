package com.springbootexceptionhandlingwithaspect.app.controller;

import com.springbootexceptionhandlingwithaspect.app.model.OrderItem;
import com.springbootexceptionhandlingwithaspect.app.request.OrderItemDTO;
import com.springbootexceptionhandlingwithaspect.app.response.OrderItemDTOResponse;
import com.springbootexceptionhandlingwithaspect.app.service.OrderItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orderitem/v1")
public class OrderItemController {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    private final OrderItemService orderItemService;

    public OrderItemController(OrderItemService orderItemService) {
        this.orderItemService = orderItemService;
    }

    // http://localhost:8082/api/orderitem/v1/orderitems
    @GetMapping("/orderitems")
    public List<OrderItem> getAll() {
        LOG.info("OrderItemController | getAll is called");
        return orderItemService.getAll();
    }

    // http://localhost:8082/api/orderitem/v1/orderitem/add
    @PostMapping("/orderitem/add")
    public OrderItem createOrderItem(@RequestBody OrderItemDTO orderItem) {
        LOG.info("OrderItemController | createOrderItem is called");
        return orderItemService.save(orderItem);
    }

    // http://localhost:8082/api/orderitem/v1/orderitem/getOrderItemById/{id}
    @GetMapping("/orderitem/getOrderItemById/{id}")
    public ResponseEntity<OrderItemDTOResponse> getOrderItemById(@PathVariable long id) {
        LOG.info("OrderItemController | getOrderItemById is called");
        OrderItemDTOResponse orderItemDTOResponse = orderItemService.findById(id);
        return ResponseEntity.ok(orderItemDTOResponse);
    }

    // http://localhost:8082/api/orderitem/v1/orderitem/update?id={id}
    @PutMapping("/orderitem/update")
    public ResponseEntity<OrderItem> updateOrderItem(@RequestParam long id, @RequestBody OrderItemDTO orderItem) {
        LOG.info("OrderItemController | updateOrderItem is called");
        OrderItem updatedOrderItem = orderItemService.update(id,orderItem);
        return ResponseEntity.ok(updatedOrderItem);
    }

    // http://localhost:8082/api/orderitem/v1/orderitem/delete/{id}
    @DeleteMapping("/orderitem/delete/{id}")
    public void deleteOrderItem(@PathVariable long id) {
        LOG.info("OrderItemController | deleteOrderItem is called");
        orderItemService.delete(id);
    }

}
