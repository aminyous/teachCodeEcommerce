package com.teachCode.ecommerce.services;

import com.teachCode.ecommerce.entities.Product;
import com.teachCode.ecommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.Optional;

@Repository
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductRepository productRepository;

    @Override
    public Optional<Product> getProductById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        return product;
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Page<Product> getProductByStatusId(Long id, int page, int size) {
        return productRepository.findByStatusId(id, page, size);
    }

    public Page<Product> searchProductByName(String name, int page, int size) {
        // Crée un objet Pageable pour la pagination
        PageRequest pageable = PageRequest.of(page, size);
        // Appelle le repository pour effectuer la recherche
        return productRepository.findByNameContainingIgnoreCase(name, pageable);
    }
}
