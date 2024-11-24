package com.teachCode.ecommerce.services;

import com.teachCode.ecommerce.entities.ProductCategory;

import java.util.List;
import java.util.Optional;

public interface ProductCategoryService {

     ProductCategory getProductCategory(Long id);
     List<ProductCategory> getProductCategoryList();
     ProductCategory createProductCategory(ProductCategory productCategory);
     ProductCategory updateProductCategory(Long id, ProductCategory productCategory);
     String deleteProductCategory(Long id);


}
