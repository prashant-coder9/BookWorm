package com.bookworm.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bookworm.entities.Invoice;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface InvoiceRepository extends JpaRepository<Invoice , Long>{


	@Query(value = "select * from invoice where customer_id =:id", nativeQuery = true)
	List<Invoice> getByCustomerId(@Param("id") long id);
	

	
}
