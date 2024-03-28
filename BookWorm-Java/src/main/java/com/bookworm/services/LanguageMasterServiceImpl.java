package com.bookworm.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookworm.entities.LanguageMaster;
import com.bookworm.dao.LanguageMasterRepository;

@Service
public class LanguageMasterServiceImpl implements LanguageMasterService {
	
	@Autowired
	LanguageMasterRepository languageMasterRepository;

	@Override
	public List<LanguageMaster> getAllLanguages() {
		return languageMasterRepository.findAll();
	}

	@Override
	public void addLanguage(LanguageMaster language) {
		languageMasterRepository.save(language);
		
	}

	@Override
	public Optional<LanguageMaster> getLanguageByTypeId(long id) {
		return languageMasterRepository.findById(id);
	}

	@Override
	public Optional<LanguageMaster> getLanguageByItsType(String type) {
		
		return languageMasterRepository.listoflanguage(type);
	}

	@Override
	public void updateLanguage(long id,LanguageMaster language) {
		languageMasterRepository.update(id,language.getLanguageDesc());
		
	
	}


	

}
