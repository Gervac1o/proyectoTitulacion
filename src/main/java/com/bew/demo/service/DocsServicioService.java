package com.bew.demo.service;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import com.bew.demo.exception.EmptyResultException;
//import com.bew.demo.model.DocsServicio;

public interface DocsServicioService {

	ResponseEntity<ByteArrayResource> load(Long fileId) throws EmptyResultException;
	String store(MultipartFile file, String idDoc) throws EmptyResultException;
	ResponseEntity<ByteArrayResource> findDoc(String idDoc);
	void deleteDoc (String idDoc);
}
