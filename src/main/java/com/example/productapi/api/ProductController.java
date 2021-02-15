package com.example.productapi.api;

import com.example.productapi.dao.ProductDao;
import com.example.productapi.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductDao productDao;

    @GetMapping("/get")
    public List<Product> getProducts(){
        return  productDao.findAll();
    }

    @PostMapping("/add")
    public void addProduct(@RequestBody Product product){
        productDao.save(product);
    }

}
