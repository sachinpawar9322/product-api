package com.example.productapi.service;

import com.example.productapi.dao.CartDao;
import com.example.productapi.dao.ItemDao;
import com.example.productapi.dao.ProductDao;
import com.example.productapi.domain.Cart;
import com.example.productapi.domain.Item;
import com.example.productapi.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    @Autowired
    private CartDao cartDao;

    @Autowired
    private ProductDao productDao;

    @Autowired
    private ItemDao itemDao;

    public void addProductToCart(Long userId, Long productId,Long quantity){

        Cart cart=getOrCreateCart(userId);

        Product product=productDao.findById(productId).get();
        Item item = new Item();
        item.setProduct(product);
        item.setQuantity(quantity);
        cart.getItems().add(item);
        item.setCart(cart);
        cartDao.save(cart);

    }

    private Cart createCart(Long userId) {
        Cart cart;
        cart = new Cart();
        cart.setUserId(userId);
        cartDao.save(cart);
        return cart;
    }

    public Cart getOrCreateCart(Long userId){
        Cart cart= cartDao.getCartByUserId(userId);

        if(cart==null){
            cart = createCart(userId);
        }
        return  cart;
    }

    public void removeItem(Long itemId) {
        itemDao.deleteById(itemId);
    }

    public void removeAllItemsFromCart(Long cartId) {
        itemDao.deleteByCartId(cartId);
    }
}
