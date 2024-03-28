package com.bookworm.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bookworm.entities.BeneficiaryMaster;

@Repository
public interface BeneficiaryRepository extends JpaRepository<BeneficiaryMaster, Long> {
	
	@Query(value = "Select * from Beneficiary_Master where Beneficiary_Master.ben_id= :id", nativeQuery = true)
	BeneficiaryMaster findByBenId(@Param("id")long id);
}
