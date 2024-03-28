package com.bookworm.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookworm.dao.GenreMasterRepository;
import com.bookworm.entities.GenreMaster;

@Service
public class GenreServiceImpl implements GenreService{
    
	@Autowired
	GenreMasterRepository g_repository;
	
	@Override
	public void addGenreMaster(GenreMaster genre) {
		g_repository.save(genre);
		
	}

	@Override
	public List<GenreMaster> getGenreMasters() {
		
		return g_repository.findAll();
	}
	
	 @Override
	    public void deleteGenreMaster(Long id) {
	        g_repository.deleteById(id);
	    }

	    @Override
	    public void updateGenreMaster(GenreMaster genre, Long id) {
	        g_repository.update(genre.getGenreDesc(), id);
	    }

	    @Override
	    public Optional<GenreMaster> getGenreMaster(Long id) {
	        return g_repository.findById(id);
	    }

		@Override
		public Optional<GenreMaster> getGenreMasterByName(String name) {
			return g_repository.findByGenreDesc(name);
		}
}
