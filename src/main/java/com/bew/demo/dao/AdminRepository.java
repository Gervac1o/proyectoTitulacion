package com.bew.demo.dao;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bew.demo.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository <Admin,Long>{

	@Query(
            value = "SELECT s FROM Admin s WHERE s.nombre = :nombre",
            nativeQuery = false)
    Optional<Admin> findByNombre(@Param("nombre") String nombre);
	
	@Query(
            value = "SELECT s FROM Admin s WHERE s.apellidos = :apellidos",
            nativeQuery = false)
    Optional<Admin> findByApellidos(@Param("apellidos") String apellidos);
	
	@Query(
            value = "SELECT s FROM Admin s WHERE s.telefono = :telefono",
            nativeQuery = false)
    Optional<Admin> findByTelefono(@Param("telefono") String telefono);
	
	@Query(
            value = "SELECT s FROM Admin s WHERE s.idUsuario = :idUsuario",
            nativeQuery = false)
    Optional<Admin> findByIdUsuario(@Param("idUsuario") Long idUsuario);
}
