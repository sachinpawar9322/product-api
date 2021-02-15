package com.example.productapi.dao;

import com.example.productapi.domain.Order;
import com.example.productapi.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDao extends JpaRepository<Order, Long> {


    List<Order> findByUserId(Long userId);
}
