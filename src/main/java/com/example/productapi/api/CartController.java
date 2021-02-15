package com.example.productapi.api;

import com.example.productapi.dao.CartDao;
import com.example.productapi.domain.Cart;
import com.example.productapi.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private CartDao cartDao;

    @GetMapping("/get/{userId}")
    public Cart getCart(@PathVariable("userId") Long userId){
        return  cartService.getOrCreateCart(userId);
    }

    @GetMapping("/add/{userId}/{productId}/{quantity}")
    public void addProductToCart(@PathVariable("userId") Long userId,@PathVariable("productId") Long productId,@PathVariable("quantity") Long quantity){
        cartService.addProductToCart(userId,productId,quantity);
    }

    @GetMapping("/remove/item/{itemId}")
    public void removeItemFromCart(@PathVariable("userId") Long itemId){
        cartService.removeItem(itemId);
    }

    @GetMapping("/remove/item/all")
    public void removeAllItemsFromCart(@PathVariable("cartId") Long cartId){
        cartService.removeItem(cartId);
    }

    @GetMapping("/hello")
    public String hello(){
        return  "HELLO WORLD";
    }

}
