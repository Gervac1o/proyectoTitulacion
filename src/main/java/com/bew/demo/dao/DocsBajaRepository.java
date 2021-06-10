package com.bew.demo.dao;

import javax.transaction.Transactional;

//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bew.demo.model.DocsBaja;

public interface DocsBajaRepository extends JpaRepository<DocsBaja, Long> {
	
	@Query(
            value = "SELECT s FROM DocsBaja s WHERE s.idDoc = :idDoc",
            nativeQuery = false)
	DocsBaja findDoc(@Param("idDoc") String idDoc);
	
	@Transactional
	@Modifying
	@Query(
            value = "DELETE FROM DocsBaja s WHERE s.idDoc = :idDoc",
            nativeQuery = false)
	void deleteDoc(@Param("idDoc") String idDoc);
}
