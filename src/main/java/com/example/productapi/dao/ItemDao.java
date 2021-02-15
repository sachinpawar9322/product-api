package com.example.productapi.dao;

import com.example.productapi.domain.Item;
import com.example.productapi.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemDao extends JpaRepository<Item, Long> {

    public void deleteByCartId(Long cartId);

}
