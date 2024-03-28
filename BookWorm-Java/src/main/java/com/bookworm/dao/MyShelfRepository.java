package com.bookworm.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bookworm.entities.MyShelf;

import jakarta.transaction.Transactional;

@Repository
public interface MyShelfRepository extends JpaRepository<MyShelf, Long> {

	@Query(value = "select * from my_shelf where customer_id =:id", nativeQuery = true)
	List<MyShelf> getByCustomerId(@Param("id") long id);
	
	List<MyShelf> findBytranTypeStartsWith(String tranType);
	
	@Query(value = "select * from my_shelf where buy_id =:id", nativeQuery = true)
	List<MyShelf> getByBuyId(@Param("id") long id);
	
	@Transactional
	@Modifying
	@Query(value = "delete from my_shelf where buy_id=:id", nativeQuery = true)
	void  deleteProduct(@Param("id") long id);


}
