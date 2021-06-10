package com.bew.demo.service;
import java.util.List;
import com.bew.demo.dto.ServicioSocialDTO;
import com.bew.demo.exception.EmptyResultException;

public interface ServicioSocialService {
	List<ServicioSocialDTO> findAll();
	ServicioSocialDTO findById(Long idServicio);
	void saveServicioSocial(ServicioSocialDTO servicioDTO);
	void updateServicioSocial(ServicioSocialDTO servicioDTO)throws EmptyResultException;
	void deleteServicioSocial(Long idServicio)throws EmptyResultException;
	ServicioSocialDTO findByIdAlumno(Long idAlumno) throws EmptyResultException;
	List<ServicioSocialDTO> findByEstado(String estado);
}