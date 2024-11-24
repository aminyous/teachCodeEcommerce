package com.teachCode.ecommerce.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartDto {

    private String userId;
    private String productId;
    private String productName;
    private String productImg;
    private int productQuantity;
    private int productPrice;

}
