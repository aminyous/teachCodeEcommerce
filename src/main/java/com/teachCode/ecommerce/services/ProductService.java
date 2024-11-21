package com.teachCode.ecommerce.services;

import com.teachCode.ecommerce.dto.ProductDTO;
import com.teachCode.ecommerce.entities.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface ProductService {
    public Optional<Product> getProductById(Long id);
    public List<Product> getAllProducts();
    public Product addProduct(Product product);
}
