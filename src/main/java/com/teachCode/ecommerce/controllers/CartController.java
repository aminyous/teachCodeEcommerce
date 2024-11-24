package com.teachCode.ecommerce.controllers;

import com.teachCode.ecommerce.dto.request.CartDto;
import com.teachCode.ecommerce.dto.response.DtoCart;
import com.teachCode.ecommerce.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
@CrossOrigin()
public class CartController {

    @Autowired
    CartService cartService;



    @PutMapping("/addProduct")
    public String addTRCart(@RequestBody CartDto cartDto){
        return cartService.addItemsToCart(cartDto);
    }

    @GetMapping("/cartItems/{user_id}")
    public List<DtoCart> getCartItems(@PathVariable(value = "user_id") String userId) {
        return cartService.getCartItems(userId);
    }


    @DeleteMapping("/{product_id}/{item_id}")
    public void deleteProduct(@PathVariable(value = "product_id") String product_id,
                              @PathVariable(value = "item_id") Long item_id) {
        cartService.deleteProduct(product_id, item_id);
    }



}
