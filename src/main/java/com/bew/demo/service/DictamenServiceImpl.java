package com.bew.demo.service;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bew.demo.dao.DictamenRepository;
import com.bew.demo.dto.DictamenDTO;
import com.bew.demo.exception.EmptyResultException;
import com.bew.demo.exception.MailRepetidoException;
import com.bew.demo.model.Dictamen;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

@Service
@Transactional
public class DictamenServiceImpl implements DictamenService {

	@Autowired
	DictamenRepository dictamenRepository;
	
	@Override
	public List<DictamenDTO> findAll() {
		
		List <DictamenDTO> dictamenDTO;
        List<Dictamen> dictamenes = dictamenRepository.findAll();
        dictamenDTO = new ArrayList<>();
        for (Dictamen dictamen : dictamenes) {
        	Mapper mapper = DozerBeanMapperBuilder.buildDefault();
        	dictamenDTO.add( mapper.map(dictamen, DictamenDTO.class));
        	
        }
        
            return dictamenDTO;
	}

	@Override
	public DictamenDTO findById(Long idDictamen) {
		DictamenDTO dictamenDTO = new DictamenDTO(); 
		Dictamen dictamen = null;
		Optional<Dictamen> opDictamen = dictamenRepository.findById(idDictamen);
		dictamen = opDictamen.get();
		
		Mapper mapper = DozerBeanMapperBuilder.buildDefault();
		dictamenDTO = ( mapper.map(dictamen, DictamenDTO.class));
		
		return dictamenDTO;
	}
	@Override
	public DictamenDTO findByIdAlumno(Long idAlumno) throws EmptyResultException{
		
		DictamenDTO dictamenDTO = new DictamenDTO();
		Dictamen dictamen = null;
		Optional<Dictamen> opDictamen = Optional.ofNullable(dictamenRepository.findByIdAlumno(idAlumno).orElseThrow(() -> new EmptyResultException("Sin Resultados")));
		dictamen = opDictamen.get();
		if(dictamen.getIdDictamen().equals(null)){
			dictamenDTO.setEstado("null");
			dictamenDTO.setFechaRegistro("null");
			dictamenDTO.setIdAlumno(idAlumno);
			return dictamenDTO;
			
		}
		else {
			Mapper mapper = DozerBeanMapperBuilder.buildDefault();
			dictamenDTO = (mapper.map(dictamen, DictamenDTO.class));
			return dictamenDTO;
		}
		
		
	}
	@Override
	public void saveDictamen(DictamenDTO dictamenDTO) {
		Dictamen dictamen;
		Mapper mapper = DozerBeanMapperBuilder.buildDefault();
		dictamen = (mapper.map(dictamenDTO, Dictamen.class));
		dictamenRepository.save(dictamen);
	}

	@Override
	public void updateDictamen(DictamenDTO dictamenDTO) throws EmptyResultException {
		Dictamen dictamen;
		Mapper mapper = DozerBeanMapperBuilder.buildDefault();
		dictamen = (mapper.map(dictamenDTO, Dictamen.class));
		dictamenRepository.save(dictamen);

	}

	@Override
	public void deleteDictamen(Long idDictamen) throws EmptyResultException {
		
		dictamenRepository.deleteById(idDictamen);
	}

	@Override
	public List<DictamenDTO> findByEstado(String estado) {
		List<DictamenDTO> dictamenDTO; 
		List<Dictamen> dictamenes = dictamenRepository.findByEstado(estado);
		dictamenDTO = new ArrayList<>();
		for(Dictamen dictamen: dictamenes) {
			Mapper mapper = DozerBeanMapperBuilder.buildDefault();
			dictamenDTO.add(mapper.map(dictamen, DictamenDTO.class));
		}
		return dictamenDTO;
	}

}
