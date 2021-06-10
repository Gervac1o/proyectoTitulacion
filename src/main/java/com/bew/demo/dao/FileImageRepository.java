package com.bew.demo.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bew.demo.model.FileImage;


@Repository
public interface FileImageRepository extends JpaRepository <FileImage, Long>{

	  
    @Query(
            value = "SELECT  c.fileName FROM FileImage c WHERE c.idDictamen = (SELECT  AVG(c2.idDictamen) FROM FileImage c2)",
            nativeQuery = false)

    Optional<FileImage> findByIdDictamen(@Param("idDictamen") Integer idDictamen);	
   
    }
//select  (file_name, file_id, id_dictamen) from file f where id_dictamen = 16
