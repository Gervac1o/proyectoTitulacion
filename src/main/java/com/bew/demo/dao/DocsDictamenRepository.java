package com.bew.demo.dao;


import javax.transaction.Transactional;

//import org.springframework.core.io.ByteArrayResource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
//import org.springframework.http.ResponseEntity;

import com.bew.demo.model.DocsDictamen;

public interface DocsDictamenRepository extends JpaRepository <DocsDictamen,Long>{
	
	@Query(
            value = "SELECT s FROM DocsDictamen s WHERE s.idDoc = :idDoc",
            nativeQuery = false)
	DocsDictamen findDoc(@Param("idDoc") String idDoc);
	
	@Transactional
	@Modifying
	@Query(
            value = "DELETE FROM DocsDictamen s WHERE s.idDoc = :idDoc",
            nativeQuery = false)
	void deleteDoc(@Param("idDoc") String idDoc);

}
