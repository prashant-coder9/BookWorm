package com.bookworm.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bookworm.entities.ProductTypeMaster;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface ProductTypeMasterRepository extends JpaRepository<ProductTypeMaster, Integer> {

    @Modifying
    @Query(value="update product_type_master p set p.type_desc = :desc where p.type_id = :id",nativeQuery = true)
    void update(@Param("desc") String type_desc, @Param("id") int type_id);

//    Optional<ProductTypeMaster> findBytype_desc(String type_Desc);
}
