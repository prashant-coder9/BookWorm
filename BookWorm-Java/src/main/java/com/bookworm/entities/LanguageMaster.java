package com.bookworm.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class LanguageMaster {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long languageId;
    private String languageDesc;
    

	public Long getLanguageId() {
		return languageId;
	}

	public void setLanguageId(Long languageId) {
		this.languageId = languageId;
	}

	public String getLanguageDesc() {
		return languageDesc;
	}

	public void setLanguageDesc(String languageDesc) {
		this.languageDesc = languageDesc;
	}

	@Override
	public String toString() {
		return "LanguageMaster [languageId=" + languageId + ", languageDesc=" + languageDesc + "]";
	}
   
	
	
	
}
