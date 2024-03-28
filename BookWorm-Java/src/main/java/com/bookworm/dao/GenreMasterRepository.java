package com.bookworm.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bookworm.entities.GenreMaster;

import jakarta.transaction.Transactional;

@Repository
public interface GenreMasterRepository extends JpaRepository<GenreMaster ,Long>{
	@Modifying
    @Query("UPDATE GenreMaster g SET g.genreDesc = :genreDesc WHERE g.genreId = :genreId")
    void update(@Param("genreDesc") String genreDesc, @Param("genreId") Long id);

	Optional<GenreMaster> findByGenreDesc(String name);
   
}
