package com.teachCode.ecommerce.services;

import com.teachCode.ecommerce.dto.request.WishListDto;
import com.teachCode.ecommerce.entities.Product;
import com.teachCode.ecommerce.entities.WishList;
import com.teachCode.ecommerce.repositories.ProductRepository;
import com.teachCode.ecommerce.repositories.WishListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class WishlistServiceImpl implements WishlistService {

    @Autowired
    WishListRepository wishListRepository;
    @Autowired
    ProductRepository productRepository;
    @Override
    public String addProductToWishListByUser(WishListDto wishListDto) {
        Optional<WishList> optionalWishList = wishListRepository.findByUserId(wishListDto.getUserId());
        Product product;
        WishList wishList;
        if (optionalWishList.isPresent()){
            wishList = optionalWishList.get();
            Optional<Product> optionalProduct = productRepository.findById(wishListDto.getProductId());
            if (optionalProduct.isPresent()){
                product = optionalProduct.get();
                if (Objects.equals(wishListDto.getProductId(), product.getId())){
                    return "Product already exists";
                } else {
                    wishList.setProduct(product);
                }
            }

        }
        return null;
    }

    @Override
    public List<WishList> getAllProductByUserWishListId(Long userId) {
        return wishListRepository.findAllWishListById(userId);
    }
}
