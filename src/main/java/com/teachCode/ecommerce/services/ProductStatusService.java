package com.teachCode.ecommerce.services;

import com.teachCode.ecommerce.entities.ProductStatus;

import java.util.List;

public interface ProductStatusService {

    List<ProductStatus> getProductStatusList();
    ProductStatus saveProductStatus(ProductStatus productStatus);
}
