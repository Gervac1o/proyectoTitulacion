package com.bew.demo.restController;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bew.demo.dto.ClienteDTO;
import com.bew.demo.exception.EmptyResultException;
import com.bew.demo.service.ClienteService;



@RestController
@RequestMapping("/cliente")
@CrossOrigin("*")
public class ClienteRestController {
	
	@Autowired
	ClienteService clienteService;

	
	@GetMapping(path = "/findAll", produces = "application/json")
	public ResponseEntity<?> findAll(){
		List<ClienteDTO> clientes;
		clientes = clienteService.findAll();
		
		return ResponseEntity.ok(clientes);
	}
	
	@GetMapping(path = "/find/{idCliente}", produces = "application/json")
	public ResponseEntity<?>find(@PathVariable("idCliente") Long idCliente){
		ClienteDTO clienteDTO;
		clienteDTO = clienteService.findById(idCliente);
		return ResponseEntity.ok(clienteDTO);		
	}
	
	@PostMapping(path = "/save", consumes = "application/json")
	public ResponseEntity<?> save(@RequestBody ClienteDTO clienteDTO){
		clienteService.saveCliente (clienteDTO);

		   return ResponseEntity.ok().build();
			
	}
	@PatchMapping(path = "/update", consumes = "application/json")
	public ResponseEntity<?> update(@RequestBody ClienteDTO clienteDTO)throws EmptyResultException{
	clienteService.updateCliente(clienteDTO);
	return ResponseEntity.ok().build();
	}
	
	@DeleteMapping(path="/delete/{idCliente}", consumes="application/json")
	public ResponseEntity<?> delete(@PathVariable("idCliente") Long idCliente) throws EmptyResultException{
		clienteService.deleteCliente(idCliente);
		return ResponseEntity.ok().build();
	}

		
/*
	@GetMapping(path = "/findNombre/{nombre}", produces = "application/json")
	public ResponseEntity<?>find(@PathVariable("nombre") String nombre) throws EmptyResultException{
		List<ClienteDTO> clienteDTO;
		clienteDTO = clienteService.clientesNombre(nombre);

	@GetMapping(path = "/findNombre/{nombre}")
	public ResponseEntity<?>find(@PathVariable("nombre") String nombre){
		ClienteDTO clienteDTO;
		clienteDTO = clienteService.ClienteNombre(nombre);
		//System.out.print(nombre);
		return ResponseEntity.ok(clienteDTO);
	}
*/
	
	
	

}
