package com.bookworm.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookworm.entities.GenreMaster;
import com.bookworm.services.GenreService;

@RestController
@CrossOrigin("*")
public class GenreMasterController {
	
	@Autowired
	private  GenreService genreServices;
	
	@PostMapping("api/addGenre")
	public void saveGenre(@RequestBody GenreMaster ref)
	{
		genreServices.addGenreMaster(ref);
	}
	
	@GetMapping("api/getGeners")
	public List<GenreMaster> getAllGenres()
	{
		return genreServices.getGenreMasters();
		
	}
	
	
	 @GetMapping("/getGenresById/{id}")
	    public Optional<GenreMaster> getGenreById(@PathVariable Long id) {
	        return genreServices.getGenreMaster(id);
	    }

	    @GetMapping("/getGenreByName/{name}")
	    public Optional<GenreMaster> getGenreByName(@PathVariable String name) {
	        return genreServices.getGenreMasterByName(name);
	    }

	    @DeleteMapping("/deleteGenre/{id}")
	    public void deleteGenre(@PathVariable Long id) {
	        genreServices.deleteGenreMaster(id);
	    }

	    @PutMapping("/updateGenre/{id}")
	    public void updateGenre(@RequestBody GenreMaster genre, @PathVariable Long id) {
	        genreServices.updateGenreMaster(genre, id);
	    }

}
