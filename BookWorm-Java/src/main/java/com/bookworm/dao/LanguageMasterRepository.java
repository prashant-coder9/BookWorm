package com.bookworm.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bookworm.entities.LanguageMaster;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface LanguageMasterRepository extends JpaRepository <LanguageMaster , Long>{
	
	@Modifying
	@Query(value="update LanguageMaster lm set lm.languageDesc=:languageDesc where lm.languageId=:id ",nativeQuery=true)
	void update(@Param("id") long languageId, @Param("languageDesc") String languageDesc);
	
	 @Query(value="SELECT lm.languageDesc FROM LanguageMaster lm WHERE lm.productType.typeDesc = :type_desc",nativeQuery=true)
	 Optional<LanguageMaster> listoflanguage(@Param("type_desc") String typeDesc);
}
