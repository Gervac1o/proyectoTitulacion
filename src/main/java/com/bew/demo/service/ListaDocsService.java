package com.bew.demo.service;

import java.util.List;



import com.bew.demo.dto.ListaDocsDTO;


public interface ListaDocsService {
	List<ListaDocsDTO> findAll();
	ListaDocsDTO findById(Long idLista);
	void saveListaDocs(ListaDocsDTO listaDocsDTO);
	void updateListaDocs(ListaDocsDTO listaDocsDTO);
	void deleteListaDocs(Long idLista);
	List<ListaDocsDTO> findDictamen(Long idAlumno);
	List<ListaDocsDTO> findLiberacion(Long idAlumno);
	List<ListaDocsDTO> findBaja(Long idAlumno);
	List<ListaDocsDTO> findServicio(Long idAlumno);

}
