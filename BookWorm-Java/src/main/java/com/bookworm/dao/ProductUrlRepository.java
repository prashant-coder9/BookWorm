package com.bookworm.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bookworm.entities.ProductUrl;

public interface ProductUrlRepository extends JpaRepository<ProductUrl, Integer> {

    @Query(value = "SELECT p.url FROM ProductUrl p WHERE p.product_Id = :productId", nativeQuery = true)
    String findUrlByProductId(@Param("productId") Integer productId);
}