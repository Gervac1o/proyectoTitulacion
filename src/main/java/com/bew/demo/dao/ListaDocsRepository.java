package com.bew.demo.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bew.demo.model.ListaDocs;

public interface ListaDocsRepository extends JpaRepository<ListaDocs,Long> {
	
	@Query(
            value = "SELECT s FROM ListaDocs s WHERE s.idAlumno = :idAlumno AND s.idTramite = 1",
            nativeQuery = false)
    List<ListaDocs> findDictamen(@Param("idAlumno") Long idAlumno);
	
	@Query(
            value = "SELECT s FROM ListaDocs s WHERE s.idAlumno = :idAlumno AND s.idTramite = 2",
            nativeQuery = false)
    List<ListaDocs> findLiberacion(@Param("idAlumno") Long idAlumno);
	
	@Query(
            value = "SELECT s FROM ListaDocs s WHERE s.idAlumno = :idAlumno AND s.idTramite = 3",
            nativeQuery = false)
    List<ListaDocs> findBaja(@Param("idAlumno") Long idAlumno);
	
	@Query(
            value = "SELECT s FROM ListaDocs s WHERE s.idAlumno = :idAlumno AND s.idTramite = 4",
            nativeQuery = false)
    List<ListaDocs> findServicio(@Param("idAlumno") Long idAlumno);
	
	/*@Query(
            value = "SELECT s TOP ListaDocs s WHERE s.idAlumno = :idAlumno AND s.idTramite = 1",
            nativeQuery = false)
    List<ListaDocs> findUltimo(@Param("idAlumno") Integer idAlumno);*/
}
