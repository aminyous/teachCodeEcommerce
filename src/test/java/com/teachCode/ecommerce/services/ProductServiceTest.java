package com.teachCode.ecommerce.services;

import com.teachCode.ecommerce.entities.Product;
import com.teachCode.ecommerce.repositories.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    ProductRepository productRepository;
    @InjectMocks
    ProductServiceImpl productService;

    @Test
    void addProductShouldAddProductSuccessfully(){
        System.out.println("First test");
//        Product product = new Product(
//                1L,
//                "Maquillage",
//                "My desc",
//                new BigDecimal("10.75"),
//                "/img/01",
//                true,
//                14
//        );

        Product product = new Product();
        product.setId(1L);
        product.setName("Maquillage");
        product.setDescription("My desc");
        product.setUnitPrice(new BigDecimal("10.75"));
        Mockito.when(productRepository.save(product)).thenReturn(product);
        Product addedProduct = productService.addProduct(product);

        Assertions.assertEquals(product.getId(), addedProduct.getId());
    }
}
