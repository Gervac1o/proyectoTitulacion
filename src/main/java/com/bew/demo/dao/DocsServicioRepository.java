package com.bew.demo.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.bew.demo.model.DocsServicio;

public interface DocsServicioRepository extends JpaRepository <DocsServicio, Long> {

	@Query(
            value = "SELECT s FROM DocsServicio s WHERE s.idDoc = :idDoc",
            nativeQuery = false)
	DocsServicio findDoc(@Param("idDoc") String idDoc);
	
	@Transactional
	@Modifying
	@Query(
            value = "DELETE FROM DocsServicio s WHERE s.idDoc = :idDoc",
            nativeQuery = false)
	void deleteDoc(@Param("idDoc") String idDoc);
}
