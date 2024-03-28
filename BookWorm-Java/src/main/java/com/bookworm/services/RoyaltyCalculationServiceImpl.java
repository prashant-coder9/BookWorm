package com.bookworm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookworm.entities.RoyaltyCalculation;
import com.bookworm.dao.RoyaltyCalculationRepository;

@Service
public class RoyaltyCalculationServiceImpl implements RoyaltyCalculationService
{
	@Autowired
	RoyaltyCalculationRepository calRepo;

	@Override
	public void addRoyality(RoyaltyCalculation obj) {
		calRepo.save(obj);
	}
	
}
