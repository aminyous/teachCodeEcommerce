package com.teachCode.ecommerce.services;

import com.teachCode.ecommerce.entities.ProductCategory;
import com.teachCode.ecommerce.repositories.ProductCategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ProductCategoryServiceImpl implements ProductCategoryService {

    ProductCategoryRepository productCategoryRepository;

    @Autowired
    public ProductCategoryServiceImpl(ProductCategoryRepository productCategoryRepository) {
        this.productCategoryRepository = productCategoryRepository;
    }

    @Override
    public ProductCategory getProductCategory(Long id) {
        Optional<ProductCategory> productCategory =  productCategoryRepository.findById(id);
        return productCategory.orElse(null);
    }

    @Override
    public List<ProductCategory> getProductCategoryList() {

        return productCategoryRepository.findAll();
    }

    @Override
    public ProductCategory createProductCategory(ProductCategory productCategory) {
        try {
            ProductCategory savedCategory = productCategoryRepository.save(productCategory);
            return savedCategory;
        } catch (Exception e) {
            log.info("Category Not created.");
            return null;
        }
    }

    @Override
    public ProductCategory updateProductCategory(Long id, ProductCategory productCategory) {

        Optional<ProductCategory> productCategoryReturned = productCategoryRepository.findById(id);
        if (productCategoryReturned.isPresent()){
            ProductCategory pro = productCategoryReturned.get();
            pro.setCategoryName(productCategory.getCategoryName());
            productCategoryRepository.save(pro);
            return pro;
        }
        return null;
    }

    @Override
    public String deleteProductCategory(Long id) {

        Optional<ProductCategory> productCategoryReturned = productCategoryRepository.findById(id);

        if (productCategoryReturned.isPresent()) {
            productCategoryRepository.deleteById(id);
            return "Deleted";
        } else {
            return "Not Found";
        }
    }
}
