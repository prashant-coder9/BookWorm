package com.bookworm.services;

import java.util.List;
import java.util.Optional;

import com.bookworm.entities.LanguageMaster;

public interface LanguageMasterService {

	List<LanguageMaster> getAllLanguages();
	
	void addLanguage(LanguageMaster language);
	
	void updateLanguage(long id,LanguageMaster language);

	Optional<LanguageMaster> getLanguageByTypeId(long id); 
	
	Optional<LanguageMaster> getLanguageByItsType(String type);

}
