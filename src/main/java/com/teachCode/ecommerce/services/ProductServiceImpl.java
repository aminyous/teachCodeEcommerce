package com.teachCode.ecommerce.services;

import com.teachCode.ecommerce.dto.ProductDTO;
import com.teachCode.ecommerce.entities.Product;
import com.teachCode.ecommerce.exceptions.ProductNotFoundException;
import com.teachCode.ecommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {

        this.productRepository = productRepository;
    }


    @Override
    public Optional<Product> getProductById(Long id) {
       // Optional<Product> product =  productRepository.findById(id);
        return productRepository.findById(id);
        //ProductDTO productDTO = new ProductDTO();
        //return productDTO.productMapper(product);


    }

    @Override
    public List<Product> getAllProducts() {

        if (productRepository.findAll().size() < 10){
            throw new ProductNotFoundException("List is less than 10");
        }
        return productRepository.findAll();
    }

    @Override
    public Product addProduct(Product product) {

        return productRepository.save(product);
    }
}
