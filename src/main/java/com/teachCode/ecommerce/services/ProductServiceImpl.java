package com.teachCode.ecommerce.services;

import com.teachCode.ecommerce.dto.ProductDTO;
import com.teachCode.ecommerce.entities.Product;
import com.teachCode.ecommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public ProductDTO getProductById(Long id) {

        Product product =  productRepository.findById(id).orElse(null);
        ProductDTO productDTO = new ProductDTO();
        return productDTO.productMapper(product);

    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }
}
