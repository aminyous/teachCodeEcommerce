package com.teachCode.ecommerce.controllers;


import com.teachCode.ecommerce.dto.ProductDTO;
import com.teachCode.ecommerce.entities.Product;
import com.teachCode.ecommerce.exceptions.ProductNotFoundException;
import com.teachCode.ecommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product/v1")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<?> getProductById(@PathVariable Long id) {
//        // Product product = productService.getProductById(id);
//
//        //return new ResponseEntity<>(product, HttpStatus.OK);
//
//            Product product = productService.getProductById(id).
//                    orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + id));
//            return ResponseEntity.ok(product);
//
//
//    }


    @GetMapping("/{id}")
    public ResponseEntity<Object> getProductById(@PathVariable Long id) {
        // Product product = productService.getProductById(id);

        //return new ResponseEntity<>(product, HttpStatus.OK);

        ProductDTO product = productService.getProductById(id);
        return ResponseEntity.ok(product);


    }


    @GetMapping
    ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostMapping("/addProduct")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        Product savedProduct = productService.addProduct(product);
        return ResponseEntity.ok(savedProduct);
    }



}
