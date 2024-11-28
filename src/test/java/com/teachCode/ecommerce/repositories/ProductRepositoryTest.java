package com.teachCode.ecommerce.repositories;

import com.teachCode.ecommerce.entities.Product;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import java.math.BigDecimal;
import java.util.List;

@DataJpaTest
public class ProductRepositoryTest {
    @Autowired
    ProductRepository productRepository;
    Product product;

    @BeforeEach
    void setUp() {
        product = new Product(
                1L,
                "Maquillage",
                "My desc",
                new BigDecimal("10.75"),
                "/img/01",
                true,
                14
        );
        productRepository.save(product);
    }


    @AfterEach
    void tearDown() {
        product = null;
        productRepository.deleteAll();
    }

    @Test
    void testFindByProductName_Found(){
        List<Product> products = productRepository.findByName("Maquillage");
        Assertions.assertThat(products.get(0).getId()).isEqualTo(product.getId());
        Assertions.assertThat(products.get(0).getDescription()).isEqualTo(product.getDescription());
    }
}
