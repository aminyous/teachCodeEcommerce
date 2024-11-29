package com.teachCode.ecommerce.services;

import com.teachCode.ecommerce.entities.ProductStatus;
import com.teachCode.ecommerce.repositories.ProductStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductStatusServiceImpl implements ProductStatusService{

    @Autowired
    ProductStatusRepository productStatusRepository;
    @Override
    public List<ProductStatus> getProductStatusList() {
        return productStatusRepository.findAll();
    }

    @Override
    public ProductStatus saveProductStatus(ProductStatus productStatus) {
        ProductStatus createdProductStatus = productStatusRepository.save(productStatus);
        return createdProductStatus;
    }
}
