package com.bookworm.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bookworm.entities.Product;
import com.bookworm.entities.ProductBenMaster;

@Repository
public interface ProductBenRepository extends JpaRepository<ProductBenMaster, Long>  
{
	@Query(value = "SELECT * FROM Product_Ben_Master WHERE Product_Ben_Master.prod_ben_product_id = :id", nativeQuery = true)
    List<ProductBenMaster> findByProductId(@Param("id") Long id);

}
