package com.bookworm.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookworm.entities.BeneficiaryMaster;
import com.bookworm.services.BeneficiaryManager;

@RestController
@CrossOrigin("*")
public class BeneficiaryController {

	
	@Autowired
	BeneficiaryManager beneficiaryManager;
	
	@GetMapping("/getAllBeneficiary")
	public List<BeneficiaryMaster> getAllBeneficiary() {
		return beneficiaryManager.getAllBeneficiary();
	}
	@GetMapping("/getByBeneficiaryId/{id}")
	public BeneficiaryMaster getByBeneficiaryId(@PathVariable long id){
		return beneficiaryManager.getByBeneficiaryId(id);
	}
	@PostMapping("/addBeneficiary")
	long addBeneficiary(@RequestBody BeneficiaryMaster benMaster) {
		return beneficiaryManager.addBeneficiary(benMaster).getBenId();
	}
	@PutMapping("/updateBeneficiary/{id}")
	String updateBeneficiary(@PathVariable long id , @RequestBody BeneficiaryMaster benMaster ) {
		return beneficiaryManager.updateBeneficiary(id,benMaster);
	}
}
