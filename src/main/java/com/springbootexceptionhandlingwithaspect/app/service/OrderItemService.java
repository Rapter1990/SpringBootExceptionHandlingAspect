package com.springbootexceptionhandlingwithaspect.app.service;

import com.springbootexceptionhandlingwithaspect.app.model.Category;
import com.springbootexceptionhandlingwithaspect.app.model.Order;
import com.springbootexceptionhandlingwithaspect.app.model.OrderItem;
import com.springbootexceptionhandlingwithaspect.app.repository.OrderItemRepository;
import com.springbootexceptionhandlingwithaspect.app.repository.OrderRepository;
import com.springbootexceptionhandlingwithaspect.app.service.impl.IOrderItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrderItemService implements IOrderItemService {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    private final OrderItemRepository orderItemRepository;

    public OrderItemService(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }


    @Override
    public List<OrderItem> getAll() {
        LOG.info("OrderItemService | getAll is called");
        return orderItemRepository.findAll();
    }

    @Override
    public OrderItem findById(Long id) {
        LOG.info("OrderItemService | findById is called");

        LOG.info("OrderItemService | findById | order : " + orderItemRepository.getById(id).toString());

        return orderItemRepository.getById(id);
    }

    @Override
    public OrderItem save(OrderItem orderItem) {
        LOG.info("OrderItemService | save is called");
        return orderItemRepository.save(orderItem);
    }

    @Override
    public void saveAll(List<OrderItem> orderItemList) {
        LOG.info("OrderItemService | saveAll is called");
        orderItemRepository.saveAll(orderItemList);
    }

    @Override
    public void delete(Long id) {
        LOG.info("OrderItemService | delete is called");
        Optional<OrderItem> orderItem = orderItemRepository.findById(id);
        if(orderItem.isPresent()) {
            OrderItem deletedOrderItem = orderItem.get();
            orderItemRepository.delete(deletedOrderItem);
            LOG.info("OrderItemService | delete | OrderItem deleted ");
        }
    }

    @Override
    public OrderItem update(Long id, OrderItem orderItem) {
        LOG.info("OrderItemService | update is called");
        Optional<OrderItem> selectedOrderItem = orderItemRepository.findById(id);
        if(selectedOrderItem.isPresent()) {
            OrderItem orderItemUpdate = selectedOrderItem.get();
            orderItemUpdate.setId(id);
            orderItemUpdate.setOrder(orderItem.getOrder());
            orderItemUpdate.setPrice(orderItem.getPrice());
            orderItemUpdate.setProduct(orderItem.getProduct());
            orderItemUpdate.setQuantity(orderItem.getQuantity());

            return orderItemRepository.save(orderItemUpdate);
        }

        return null;
    }
}
