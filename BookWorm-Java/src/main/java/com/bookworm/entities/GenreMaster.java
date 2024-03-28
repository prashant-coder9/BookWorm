package com.bookworm.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity 
public class GenreMaster {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long genreId;
	private String genreDesc;
	public Long getGenreId() {
		return genreId;
	}
	public void setGenreId(Long genreId) {
		this.genreId = genreId;
	}
	public String getGenreDesc() {
		return genreDesc;
	}
	public void setGenreDesc(String genreDesc) {
		this.genreDesc = genreDesc;
	}
	@Override
	public String toString() {
		return "GenreMaster [genreId=" + genreId + ", genreDesc=" + genreDesc + "]";
	}
	
	

}
