package com.teachCode.ecommerce.repositories;

import com.teachCode.ecommerce.entities.WishList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WishListRepository extends JpaRepository<WishList, Long> {

//    @Query(
//            value = "SELECT w FROM WishList w WHERE w.userId = :userId"
//    )
//    List<WishList> findAllWishListById(Long userId);
}
