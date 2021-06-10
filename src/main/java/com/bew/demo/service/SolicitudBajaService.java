package com.bew.demo.service;
import java.util.List;
import com.bew.demo.dto.SolicitudBajaDTO;
import com.bew.demo.exception.EmptyResultException;

public interface SolicitudBajaService {
	List<SolicitudBajaDTO> findAll();
	SolicitudBajaDTO findById(Long idSolicitud);
	void saveSolicitudBaja(SolicitudBajaDTO solicitudDTO);
	void updateSolicitudBaja(SolicitudBajaDTO solicitudDTO)throws EmptyResultException;
	void deleteSolicitudBaja(Long idSolicitud)throws EmptyResultException;
	SolicitudBajaDTO findByIdAlumno(Long idAlumno) throws EmptyResultException;
	List<SolicitudBajaDTO> findByEstado(String estado);
}