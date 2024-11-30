package com.teachCode.ecommerce.services;

import com.teachCode.ecommerce.dto.request.WishListDto;
import com.teachCode.ecommerce.entities.WishList;

import java.util.List;

public interface WishlistService {

    String addProductToWishListByUser(WishListDto wishListDto);
    List<WishList> getAllProductByUserWishListId(Long userId);
}
