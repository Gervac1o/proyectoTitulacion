package com.bew.demo.service;

import java.util.List;

import com.bew.demo.dto.ClienteDTO;
import com.bew.demo.exception.EmptyResultException;


public interface ClienteService {

	List<ClienteDTO> findAll();
	ClienteDTO findById(Long idCliente);
	void saveCliente(ClienteDTO clienteDTO);
    void updateCliente(ClienteDTO clienteDTO)throws EmptyResultException;
    void deleteCliente(Long idCliente) throws EmptyResultException;
   // ClienteDTO ClienteNombre (String nombre) throws EmptyResultException ;
    //Optional <ClienteDTO> clientesNombre (String nombre) throws EmptyResultException ;
	List<ClienteDTO> clientesNombre(String nombre);
 
}
