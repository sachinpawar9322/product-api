package com.example.productapi.domain;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class Order {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy = "cart")
    private List<Item> items;

    private Long userId;

    public Order(Cart cart) {

       this.items= cart.getItems().stream().map(item -> new Item(item)).collect(Collectors.toList());

    }
}
