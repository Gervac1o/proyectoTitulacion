package com.bew.demo.restController;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bew.demo.dto.LiberacionExtempDTO;
import com.bew.demo.exception.EmptyResultException;
import com.bew.demo.service.LiberacionExtempService;
@RestController
@RequestMapping("/liberacionExtemporanea")
@CrossOrigin("*")
public class LiberacionExtempRestController {
	
	@Autowired
	LiberacionExtempService liberacionService;
	
	@GetMapping(path = "/findAll", produces = "application/json")
	public ResponseEntity<?> buscar(){
		List<LiberacionExtempDTO> liberaciones;
		liberaciones = liberacionService.findAll();
		return ResponseEntity.ok(liberaciones);
	}
	@GetMapping(path = "/find/{idLiberacion}", produces = "application/json")
	public ResponseEntity<?>find(@PathVariable("idLiberacion") Long idLiberacion){
		LiberacionExtempDTO liberacionDTO;
		liberacionDTO = liberacionService.findById(idLiberacion);
		return ResponseEntity.ok(liberacionDTO);		
	}
	@GetMapping(path = "/findIdAlumno/{idAlumno}", produces = "application/json")
	public ResponseEntity<?>findByIdAlumno(@PathVariable("idAlumno") Long idAlumno) throws IOException, EmptyResultException{
		LiberacionExtempDTO liberacionDTO;
		try {
			liberacionDTO = liberacionService.findByIdAlumno(idAlumno);
			return ResponseEntity.ok(liberacionDTO);
		}catch(EmptyResultException e) {
			  HttpHeaders responseHeaders = new HttpHeaders();
	            responseHeaders.setContentType(MediaType.TEXT_HTML);
	            return new ResponseEntity<>(
	                    e.getMessage(),
	                    HttpStatus.ACCEPTED);
			
		}
		
		
				
	}
	@GetMapping(path = "/findEstado/{estado}", produces = "application/json")
	public ResponseEntity<?>findEstado(@PathVariable("estado") String estado){
		List<LiberacionExtempDTO> liberacionDTO;
		liberacionDTO = liberacionService.findByEstado(estado);
		
		return ResponseEntity.ok(liberacionDTO);
	}
	@PostMapping(path = "/save", consumes = "application/json")
	public ResponseEntity<?> save(@RequestBody LiberacionExtempDTO liberacionDTO){
	liberacionService.saveLiberacionExtemp (liberacionDTO);
	return ResponseEntity.ok().build();
	}
	@PatchMapping(path = "/update", consumes = "application/json")
	public ResponseEntity<?> update(@RequestBody LiberacionExtempDTO liberacionDTO)throws EmptyResultException{
	liberacionService.updateLiberacionExtemp(liberacionDTO);
	return ResponseEntity.ok().build();
	}
	
	@DeleteMapping(path = "/delete/{idLiberacion}")
	public ResponseEntity<?> delete(@PathVariable("idLiberacion") Long idLiberacion) throws EmptyResultException{
	liberacionService.deleteLiberacionExtemp(idLiberacion);
	return ResponseEntity.ok().build();
	}
}