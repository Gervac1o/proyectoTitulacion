package com.bew.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bew.demo.model.Dictamen;


public interface DictamenRepository  extends JpaRepository <Dictamen,Long>{
	
	@Query(
            value = "SELECT s FROM Dictamen s WHERE s.idAlumno = :idAlumno",
            nativeQuery = false)
    Optional<Dictamen> findByIdAlumno(@Param("idAlumno") Long idAlumno
    		);
	
	@Query(
            value = "SELECT s FROM Dictamen s WHERE s.estado = :estado",
            nativeQuery = false)
    List<Dictamen> findByEstado(@Param("estado") String estado);

}
