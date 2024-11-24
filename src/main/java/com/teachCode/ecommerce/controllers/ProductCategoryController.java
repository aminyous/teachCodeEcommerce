package com.teachCode.ecommerce.controllers;

import com.teachCode.ecommerce.entities.ProductCategory;
import com.teachCode.ecommerce.services.ProductCategoryService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/productCategory")
@CrossOrigin
@RestController
public class ProductCategoryController {

    ProductCategoryService productCategoryService;

    @Autowired
    public ProductCategoryController(ProductCategoryService productCategoryService) {
        this.productCategoryService = productCategoryService;
    }

    @GetMapping("/all")
    public List<ProductCategory> getProductCategoryList(){

        return productCategoryService.getProductCategoryList();
    }

    @PostMapping
    public ProductCategory createProductCategory(@RequestBody ProductCategory productCategory) {
        return productCategoryService.createProductCategory(productCategory);
    }

    @PutMapping("/{id}")
    public ProductCategory updateProductCategory(
            @PathVariable Long id,
            @RequestBody ProductCategory productCategory) {
        return productCategoryService.updateProductCategory(id, productCategory);
    }

    @DeleteMapping("/{id}")
    public String deleteProductCategory(@PathVariable Long id) {
        productCategoryService.deleteProductCategory(id);
        return "Category with ID " + id + " has been deleted.";
    }


    @GetMapping("/{id}")
    public ProductCategory getProductCategory(@PathVariable Long id) {
        return productCategoryService.getProductCategory(id);

    }
}
