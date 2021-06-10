package com.bew.demo.service;
import java.util.List;
import com.bew.demo.dto.LiberacionExtempDTO;
import com.bew.demo.exception.EmptyResultException;

public interface LiberacionExtempService {
	List<LiberacionExtempDTO> findAll();
	LiberacionExtempDTO findById(Long idLiberacion);
	void saveLiberacionExtemp(LiberacionExtempDTO liberacionDTO);
	void updateLiberacionExtemp(LiberacionExtempDTO liberacionDTO)throws EmptyResultException;
	void deleteLiberacionExtemp(Long idLiberacion)throws EmptyResultException;
	LiberacionExtempDTO findByIdAlumno(Long idAlumno)throws EmptyResultException;
	List<LiberacionExtempDTO> findByEstado(String estado);
}