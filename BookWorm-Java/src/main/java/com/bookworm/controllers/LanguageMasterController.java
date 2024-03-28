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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookworm.entities.LanguageMaster;
import com.bookworm.services.LanguageMasterService;

@RestController
@CrossOrigin("*")

public class LanguageMasterController {
	
	@Autowired
	private LanguageMasterService ilservices;

	@GetMapping(value = "/api/getAllLanguages")
	public List<LanguageMaster> getAllLanguages()
	{
	   return ilservices.getAllLanguages();
		
	}
	
	@PostMapping(value = "/api/add")
	public void addLanguage(@RequestBody LanguageMaster language) {
	       ilservices.addLanguage(language);
	}
	
	@PutMapping(value = "/api/update/{id}")
	public void updateLanguage(@PathVariable long id,@RequestBody LanguageMaster language) {
	       ilservices.updateLanguage(id, language);
	}
	
	@GetMapping(value="/api/getByTypeId/{id}")
	public Optional<LanguageMaster> getLanguageByTypeId(@PathVariable long id)
	{
		return ilservices.getLanguageByTypeId(id);
	}
	
	@GetMapping(value = "/api/getByType/{type}")
	public Optional<LanguageMaster> getLanguageByItsType(@PathVariable String type)
	{
		return ilservices.getLanguageByItsType(type);
	}
	
}

