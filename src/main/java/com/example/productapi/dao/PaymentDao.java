package com.example.productapi.dao;

import com.example.productapi.domain.Payment;
import com.example.productapi.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentDao extends JpaRepository<Payment, Long> {

}
