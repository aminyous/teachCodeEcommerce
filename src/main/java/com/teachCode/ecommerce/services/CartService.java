package com.teachCode.ecommerce.services;

import com.teachCode.ecommerce.dto.request.CartDto;
import com.teachCode.ecommerce.dto.response.DtoCart;

import java.util.List;

public interface CartService {

    String addItemsToCart(CartDto cartDto);

    List<DtoCart> getCartItems(String userId);

    void deleteProduct(String productId, Long userId);
}
