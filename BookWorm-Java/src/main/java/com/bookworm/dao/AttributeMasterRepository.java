package com.bookworm.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bookworm.entities.AttributeMaster;

public interface AttributeMasterRepository extends JpaRepository<AttributeMaster,Integer> 
{
	@Modifying
	@Query("update AttributeMaster a set a.attribute_desc = :desc where a.attribute_id = :id")
	void update(@Param("desc") String desc,@Param("id") int id);


}