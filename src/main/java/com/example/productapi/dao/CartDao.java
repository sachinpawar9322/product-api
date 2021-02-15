package com.example.productapi.dao;

import com.example.productapi.domain.Cart;
import com.example.productapi.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartDao extends JpaRepository<Cart, Long> {

    public Cart getCartByUserId(Long userId);

}
