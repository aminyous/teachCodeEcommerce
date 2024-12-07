package com.teachCode.ecommerce.services;

import com.teachCode.ecommerce.entities.Product;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.Optional;

public interface ProductService {

    Optional<Product> getProductById(Long id);

    Product createProduct(Product product);

    Page<Product> getProductByStatusId(Long id, int page, int size);
    Page<Product> searchProductByName(String name, int page, int size);
}
