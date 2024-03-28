package com.bookworm.services;

import java.util.List;
import java.util.Optional;

import com.bookworm.entities.BeneficiaryMaster;

public interface BeneficiaryManager {

	List<BeneficiaryMaster> getAllBeneficiary();
	BeneficiaryMaster getByBeneficiaryId(long id);
	BeneficiaryMaster addBeneficiary(BeneficiaryMaster benMaster);
	
	String updateBeneficiary(long id ,BeneficiaryMaster benMaster );
	
}
