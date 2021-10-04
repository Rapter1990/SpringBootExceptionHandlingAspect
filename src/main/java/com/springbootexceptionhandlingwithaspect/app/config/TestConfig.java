package com.springbootexceptionhandlingwithaspect.app.config;

import com.springbootexceptionhandlingwithaspect.app.model.*;
import com.springbootexceptionhandlingwithaspect.app.model.enums.OrderStatus;
import com.springbootexceptionhandlingwithaspect.app.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.Instant;
import java.util.Arrays;

@Configuration
public class TestConfig implements CommandLineRunner {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    private final UserService userService;

    private final OrderService orderService;

    private final CategoryService categoryService;

    private final ProductService productService;

    private final OrderItemService orderItemService;

    public TestConfig(UserService userService, OrderService orderService, CategoryService categoryService, ProductService productService, OrderItemService orderItemService) {
        this.userService = userService;
        this.orderService = orderService;
        this.categoryService = categoryService;
        this.productService = productService;
        this.orderItemService = orderItemService;
    }


    @Override
    public void run(String... args) throws Exception {

        LOG.info("TestConfig | run is called");

        // Category
        Category cat1 = new Category();
        cat1.setName("Electronics");
        Category cat2 = new Category();
        cat2.setName("Books");
        Category cat3 = new Category();
        cat3.setName("Computers");


        categoryService.saveAll(Arrays.asList(cat1, cat2, cat3));
        LOG.info("TestConfig | run | All categories are added");

        // Product
        Product p1 =  new Product();
        p1.setName("The Lord of the Rings");
        p1.setDescription("Lorem ipsum dolor sit amet, consectetur.");
        p1.setPrice(2190.0);
        p1.getCategories().add(cat2);

        Product p2 =  new Product();
        p2.setName("Smart TV");
        p2.setDescription("Nulla eu imperdiet purus. Maecenas ante.");
        p2.setPrice(1250.0);
        p2.getCategories().add(cat1);

        Product p3 =  new Product();
        p3.setName("PC Gamer");
        p3.setDescription("Donec aliquet odio ac rhoncus cursus.");
        p3.setPrice(1200.0);
        p3.getCategories().add(cat3);

        Product p4 =  new Product();
        p4.setName("Rails for Dummies");
        p4.setDescription("Cras fringilla convallis sem vel faucibus.");
        p4.setPrice(100.99);
        p1.getCategories().add(cat2);

        productService.saveAll(Arrays.asList(p1, p2, p3, p4));
        LOG.info("TestConfig | run | All products are added");

        // User
        User u1 = new User();
        u1.setName("Maria Brown");
        u1.setEmail("maria@gmail.com");
        u1.setPhone("988888888");
        u1.setPassword("123456");

        User u2 = new User();
        u2.setName("Alex Green");
        u2.setEmail("alex@gmail.com");
        u2.setPhone("977777777");
        u2.setPassword("123456");

        userService.saveAll(Arrays.asList(u1, u2));
        LOG.info("TestConfig | run | All users are added");

        // Order and Payment
        Order o1 = new Order();
        o1.setMoment(Instant.parse("2019-06-20T19:53:07Z"));
        o1.setOrderStatus(OrderStatus.PAID.getCode());

        Payment pay1 = new Payment(null, Instant.parse("2019-06-20T21:53:07Z"), o1);
        o1.setPayment(pay1);

        o1.getUsers().add(u1);

        Order o2 = new Order();
        o2.setMoment(Instant.parse("2019-07-21T03:42:10Z"));
        o2.setOrderStatus(OrderStatus.WAINTING_PAYMENT.getCode());

        Payment pay2 = new Payment(null, Instant.parse("2019-06-20T21:53:07Z"), o2);
        o2.setPayment(pay2);

        o2.getUsers().add(u2);

        // OrderItem
        OrderItem oi1 = new OrderItem();
        oi1.setProduct(p1);
        oi1.setPrice(p1.getPrice());
        oi1.setOrder(o1);
        oi1.setQuantity(2);

        OrderItem oi2 = new OrderItem();
        oi2.setProduct(p3);
        oi2.setPrice(p3.getPrice());
        oi2.setOrder(o2);
        oi2.setQuantity(2);

        orderItemService.saveAll(Arrays.asList(oi1, oi2));
        LOG.info("TestConfig | run | All orderItems are added");

        orderService.saveAll(Arrays.asList(o1, o2));
        LOG.info("TestConfig | run | All orders are added");
    }
}
