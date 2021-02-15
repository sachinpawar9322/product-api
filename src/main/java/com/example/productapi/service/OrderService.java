package com.example.productapi.service;

import com.example.productapi.dao.CartDao;
import com.example.productapi.dao.OrderDao;
import com.example.productapi.domain.Cart;
import com.example.productapi.domain.Order;
import com.example.productapi.payment.PaymentGateway;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private PaymentGateway paymentGateway;

    @Autowired
    private CartDao cartDao;

    @Autowired
    private OrderDao orderDao;

    public String makePayment(Double amount) {
        return paymentGateway.processPayment("TEST", amount);
    }

    public void placeOrder(Long userId, String paymentId) {

        boolean isPaidFor = paymentGateway.validateTransaction(paymentId);

        if (isPaidFor) {

            Cart cart = cartDao.getCartByUserId(userId);

            Order order = new Order(cart);

            orderDao.save(order);

        } else {
            throw new IllegalArgumentException("Payment Id is not valid");
        }

    }

    public Order getOrderDetails(Long orderId) {
        return orderDao.findById(orderId).get();
    }

    public List<Order> getOrdersForUser(Long userId) {
        return orderDao.findByUserId(userId);
    }

}
