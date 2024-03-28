package com.bookworm.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bookworm.entities.ProductAttribute;

public interface ProductAttributeRepository extends JpaRepository<ProductAttribute,Long>
{
	@Modifying
	@Query("update ProductAttribute set attributeValue=:attributeValue where prodAttId=:prodAttId")
	void update(@Param ("attributeValue") String attributevalue,@Param("prodAttId")long id);

}