package com.bew.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bew.demo.dao.ClienteRepository;
import com.bew.demo.dto.ClienteDTO;
import com.bew.demo.exception.EmptyResultException;
import com.bew.demo.model.Cliente;

@Service
@Transactional
public class ClienteServiceImpl implements ClienteService {
	
	@Autowired
	ClienteRepository clienteRepository;
	
    @Override
    public List<ClienteDTO> findAll()  {

       List <ClienteDTO> clienteDTO;
        List<Cliente> clientes = clienteRepository.findAll();
        	clienteDTO = new ArrayList<>();
 
        for (Cliente cliente : clientes) {
        
        	Mapper mapper = DozerBeanMapperBuilder.buildDefault();
        	clienteDTO.add( mapper.map(cliente, ClienteDTO.class));
        	
        }
        
            return clienteDTO;
        }
    


	@Override
	public ClienteDTO findById(Long idCliente){

		ClienteDTO clienteDTO = new ClienteDTO(); 
		Cliente cliente = null;
		Optional<Cliente> opCliente = clienteRepository.findById(idCliente);
		cliente = opCliente.get();
		
		Mapper mapper = DozerBeanMapperBuilder.buildDefault();
    	clienteDTO = ( mapper.map(cliente, ClienteDTO.class));
		
		return clienteDTO;
		
	
	}

	@Override
	public void saveCliente(ClienteDTO clienteDTO) {
		
		Cliente cliente;
		Mapper mapper = DozerBeanMapperBuilder.buildDefault();
		cliente = (mapper.map(clienteDTO, Cliente.class));
    	clienteRepository.save(cliente);
		
		//System.out.println(clienteDTO);
	}

	@Override
	public void updateCliente(ClienteDTO clienteDTO) throws EmptyResultException {
		// TODO Auto-generated method stub
		Cliente cliente;
		Mapper mapper = DozerBeanMapperBuilder.buildDefault();
		cliente = (mapper.map(clienteDTO, Cliente.class));
		clienteRepository.save(cliente);
	}

	@Override
	public void deleteCliente(Long idCliente) throws EmptyResultException {
		clienteRepository.deleteById(idCliente);
	}

	
	@Override
	public List<ClienteDTO> clientesNombre(String nombre) {
			
		 List<ClienteDTO> clienteDTO = new ArrayList<>();
		 List<Cliente> clientes = clienteRepository.findByNombre(nombre);
		
		 Mapper mapper = DozerBeanMapperBuilder.buildDefault();
		
		
		for(Cliente cliente : clientes) {
			clienteDTO.add( mapper.map(cliente, ClienteDTO.class));
		}
			
	

		return clienteDTO;
	}
	

}
