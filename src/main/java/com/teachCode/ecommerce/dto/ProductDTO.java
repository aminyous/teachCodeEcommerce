package com.teachCode.ecommerce.dto;

import com.teachCode.ecommerce.entities.Product;
import jakarta.persistence.Column;

import java.math.BigDecimal;

public class ProductDTO {

    private String name;

    private String description;

    private BigDecimal unitPrice;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public ProductDTO productMapper(Product product){
        this.setName(product.getName());
        this.setDescription(product.getDescription());
        this.setUnitPrice(product.getUnitPrice());
        return this;
    }






}
