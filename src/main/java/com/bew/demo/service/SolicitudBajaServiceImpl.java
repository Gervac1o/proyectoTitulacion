package com.bew.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bew.demo.dao.SolicitudBajaRepository;
import com.bew.demo.dto.SolicitudBajaDTO;
import com.bew.demo.exception.EmptyResultException;
import com.bew.demo.model.SolicitudBaja;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

@Service
@Transactional
public class SolicitudBajaServiceImpl implements SolicitudBajaService {

	@Autowired
	SolicitudBajaRepository solicitudRepository;
	
	@Override
	public List<SolicitudBajaDTO> findAll(){
		List<SolicitudBajaDTO> solicitudDTO;
		List<SolicitudBaja> solicitudes = solicitudRepository.findAll();
		solicitudDTO = new ArrayList<>();
		for(SolicitudBaja solicitud: solicitudes) {
			Mapper mapper = DozerBeanMapperBuilder.buildDefault();
			solicitudDTO.add(mapper.map(solicitud, SolicitudBajaDTO.class));
		}
		// TODO Auto-generated method stub
		return solicitudDTO;
	}

	@Override
	public SolicitudBajaDTO findById(Long idSolicitud) {
		SolicitudBajaDTO solicitudDTO = new SolicitudBajaDTO(); 
		SolicitudBaja solicitud = null;
		Optional<SolicitudBaja> opSolicitud = solicitudRepository.findById(idSolicitud);
		solicitud = opSolicitud.get();
		
		Mapper mapper = DozerBeanMapperBuilder.buildDefault();
		solicitudDTO = ( mapper.map(solicitud, SolicitudBajaDTO.class));
		
		return solicitudDTO;
	}

	@Override
	public SolicitudBajaDTO findByIdAlumno(Long idAlumno)throws EmptyResultException {
		SolicitudBajaDTO solicitudDTO = new SolicitudBajaDTO(); 
		SolicitudBaja solicitud = null;
		Optional<SolicitudBaja> opSolicitud = Optional.ofNullable(solicitudRepository.findByIdAlumno(idAlumno).orElseThrow(()-> new EmptyResultException ("sin resultados")));
		solicitud = opSolicitud.get();
		
		Mapper mapper = DozerBeanMapperBuilder.buildDefault();
		solicitudDTO = ( mapper.map(solicitud, SolicitudBajaDTO.class));
		
		return solicitudDTO;
	}
	@Override
	public void saveSolicitudBaja(SolicitudBajaDTO solicitudDTO) {
		// TODO Auto-generated method stub
		SolicitudBaja solicitud;
		Mapper mapper = DozerBeanMapperBuilder.buildDefault();
		solicitud = (mapper.map(solicitudDTO, SolicitudBaja.class));
    	solicitudRepository.save(solicitud);
	}

	@Override
	public void updateSolicitudBaja(SolicitudBajaDTO solicitudDTO) throws EmptyResultException {
		// TODO Auto-generated method stub
		SolicitudBaja solicitud;
		Mapper mapper = DozerBeanMapperBuilder.buildDefault();
		solicitud = (mapper.map(solicitudDTO, SolicitudBaja.class));
		solicitudRepository.save(solicitud);
	}

	@Override
	public void deleteSolicitudBaja(Long idSolicitud) throws EmptyResultException {
		// TODO Auto-generated method stub
		solicitudRepository.deleteById(idSolicitud);
	}

	@Override
	public List<SolicitudBajaDTO> findByEstado(String estado) {
		List<SolicitudBajaDTO> solicitudDTO; 
		List<SolicitudBaja> solicitudes = solicitudRepository.findByEstado(estado);
		solicitudDTO = new ArrayList<>();
		for(SolicitudBaja solicitud: solicitudes) {
			Mapper mapper = DozerBeanMapperBuilder.buildDefault();
			solicitudDTO.add(mapper.map(solicitud, SolicitudBajaDTO.class));
		}
		return solicitudDTO;
	}

}
