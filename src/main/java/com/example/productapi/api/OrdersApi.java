package com.example.productapi.api;

import com.example.productapi.domain.Order;
import com.example.productapi.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrdersApi {

    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    private void createOrder(Long userId, String paymentId ){
        orderService.placeOrder(userId,paymentId);
    }

    @PostMapping("/get/{orderId}")
    private Order getOrder(Long orderId ){
      return orderService.getOrderDetails(orderId);
    }

    @PostMapping("/user/get/{userId}")
    private List<Order> getAllOrdersForUser(Long userId ){
        return orderService.getOrdersForUser(userId);
    }

}
