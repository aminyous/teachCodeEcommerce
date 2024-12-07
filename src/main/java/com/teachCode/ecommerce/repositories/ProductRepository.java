package com.teachCode.ecommerce.repositories;

import com.teachCode.ecommerce.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Page<Product> findByStatusId(Long statusId, int page, int size);

    Page<Product> findByNameContainingIgnoreCase(String name, Pageable pageable);
}
