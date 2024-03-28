package com.bookworm.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bookworm.entities.BeneficiaryMaster;
import com.bookworm.entities.Invoice;
import com.bookworm.entities.Product;
import com.bookworm.entities.RoyaltyCalculation;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface RoyaltyCalculationRepository extends JpaRepository<RoyaltyCalculation, Long>{

	@Query(value = "select * from royalty_calculation where ben_id= :id", nativeQuery = true)
	List<RoyaltyCalculation> getByBeneficiaryId(@Param("id") long benId);
	
	@Query(value = "select * from royalty_calculation where prod_id= :id", nativeQuery = true)
	List<RoyaltyCalculation> getByProductId(@Param("id") long productId);
	
	@Query(value = "select * from royalty_calculation where invoice_id= :id", nativeQuery = true)
	List<RoyaltyCalculation> getByInvoiceId(@Param("id") long invoiceId);
	
	
}
