package com.springbootexceptionhandlingwithaspect.app.service;

import com.springbootexceptionhandlingwithaspect.app.model.Order;
import com.springbootexceptionhandlingwithaspect.app.model.OrderItem;
import com.springbootexceptionhandlingwithaspect.app.model.Product;
import com.springbootexceptionhandlingwithaspect.app.repository.OrderItemRepository;
import com.springbootexceptionhandlingwithaspect.app.repository.OrderRepository;
import com.springbootexceptionhandlingwithaspect.app.repository.ProductRepository;
import com.springbootexceptionhandlingwithaspect.app.request.OrderItemDTO;
import com.springbootexceptionhandlingwithaspect.app.response.OrderDTOResponse;
import com.springbootexceptionhandlingwithaspect.app.response.OrderItemDTOResponse;
import com.springbootexceptionhandlingwithaspect.app.service.impl.IOrderItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class OrderItemService implements IOrderItemService {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    private final OrderItemRepository orderItemRepository;

    private final ProductRepository productRepository;

    private final OrderRepository orderRepository;

    public OrderItemService(OrderItemRepository orderItemRepository,OrderRepository orderRepository, ProductRepository productRepository) {

        this.orderItemRepository = orderItemRepository;
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;

    }


    @Override
    public List<OrderItem> getAll() {
        LOG.info("OrderItemService | getAll is called");
        return orderItemRepository.findAll();
    }

    @Override
    public OrderItemDTOResponse findById(Long id) {
        LOG.info("OrderItemService | findById is called");

        Optional<OrderItem> orderItem = orderItemRepository.findById(id);
        if(orderItem.isPresent()) {
            OrderItem selectedOrderItem = orderItem.get();
            OrderItemDTOResponse orderItemDTOResponse = new OrderItemDTOResponse();
            orderItemDTOResponse.setOrder(selectedOrderItem.getOrder());
            orderItemDTOResponse.setPrice(selectedOrderItem.getPrice());
            orderItemDTOResponse.setProduct(selectedOrderItem.getProduct());
            orderItemDTOResponse.setQuantity(selectedOrderItem.getQuantity());

            return orderItemDTOResponse;
        }

        return null;
    }

    @Override
    public OrderItem save(OrderItemDTO orderItemDTO) {
        LOG.info("OrderItemService | save is called");

        Order order = orderRepository.getById(orderItemDTO.getOrderId());
        Product product = productRepository.getById(orderItemDTO.getProductId());

        OrderItem orderItem = new OrderItem();
        orderItem.setQuantity(orderItemDTO.getQuantity());
        orderItem.setOrder(order);
        orderItem.setProduct(product);
        orderItem.setPrice(orderItemDTO.getPrice());

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
    public OrderItem update(Long id, OrderItemDTO orderItemDTO) {
        LOG.info("OrderItemService | update is called");
        Optional<OrderItem> selectedOrderItem = orderItemRepository.findById(id);

        Order order = orderRepository.getById(orderItemDTO.getOrderId());
        Product product = productRepository.getById(orderItemDTO.getProductId());

        if(selectedOrderItem.isPresent()) {
            OrderItem orderItemUpdate = selectedOrderItem.get();
            orderItemUpdate.setId(id);
            orderItemUpdate.setQuantity(orderItemDTO.getQuantity());
            orderItemUpdate.setOrder(order);
            orderItemUpdate.setProduct(product);
            orderItemUpdate.setPrice(orderItemDTO.getPrice());

            return orderItemRepository.save(orderItemUpdate);
        }

        return null;
    }
}
