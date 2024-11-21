package com.teachCode.ecommerce.services;

import com.teachCode.ecommerce.entities.Product;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProductService {
    public Product getProductById(Long id);
    public List<Product> getAllProducts();
    public Product addProduct(Product product);
}
