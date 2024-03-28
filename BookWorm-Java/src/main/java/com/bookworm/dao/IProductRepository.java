package com.bookworm.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.bookworm.entities.Product;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {
	
	
	 @Query(value = "Select * from Product where Product.product_id = :id", nativeQuery = true) 
	 Product getById(@Param("id") long id);
	 
	@Query(value = "Select * from Product where Product.type_id= :type_id and Product.language_Id = :lang_id", nativeQuery = true)
	List<Product> getByTypeIdandLangID(@Param("type_id") long typeId, @Param("lang_id") long langId);
	
	@Query(value = "Select * from Product where Product.type_id= :type_id", nativeQuery = true)
	List<Product> getByTypeID(@Param("type_id") long typeId);
	@Query(value = "Select * from Product where Product.product_id= :id", nativeQuery = true)
	Product findByProductId(@Param("id")Long id);
	@Query(value="Select * from Product where Product.type_id= :type_id and Product.language_Id = :lang_id and Product.genre_id=:genre_id", nativeQuery = true )
	List<Product> getByTypeandGenre(@Param("type_id") long typeId, @Param("lang_id") long langId,@Param("genre_id")long genreId);       
		
	
}
    