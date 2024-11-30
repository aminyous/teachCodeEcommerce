package com.teachCode.ecommerce.repositories;

import com.teachCode.ecommerce.entities.Cart;
import com.teachCode.ecommerce.entities.WishList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WishListRepository extends JpaRepository<WishList, Long> {

    @Query(
            value = "SELECT w FROM WishList w WHERE w.userId = :userId"
    )
    List<WishList> findAllWishListById(Long userId);

    Optional<WishList> findByUserId(Long userId);
}
