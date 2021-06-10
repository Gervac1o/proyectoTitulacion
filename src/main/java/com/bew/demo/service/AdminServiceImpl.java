package com.bew.demo.service;

import java.util.ArrayList;


import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bew.demo.dao.AdminRepository;
import com.bew.demo.dto.AdminDTO;
import com.bew.demo.exception.EmptyResultException;
import com.bew.demo.model.Admin;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminRepository adminRepository;
	
	@Override
	public List<AdminDTO> findAll(){
		List<AdminDTO> adminDTO;
		List<Admin> admins = adminRepository.findAll();
		adminDTO = new ArrayList<>();
		for(Admin admin: admins) {
			Mapper mapper = DozerBeanMapperBuilder.buildDefault();
			adminDTO.add(mapper.map(admin, AdminDTO.class));
		}
		// TODO Auto-generated method stub
		return adminDTO;
	}

	@Override
	public AdminDTO findById(Long idAdmin) {
		
		AdminDTO adminDTO = new AdminDTO(); 
		Admin admin = null;
		Optional<Admin> opAdmin = adminRepository.findById(idAdmin);
		admin = opAdmin.get();
		
		Mapper mapper = DozerBeanMapperBuilder.buildDefault();
    	adminDTO = ( mapper.map(admin, AdminDTO.class));
		
		return adminDTO;
	}
	@Override
	public AdminDTO findByIdUsuario(Long idUsuario) {
		
		AdminDTO adminDTO = new AdminDTO(); 
		Admin admin = null;
		System.out.println(idUsuario + "Antes de Admin Repository" );
		Optional<Admin> opAdmin = adminRepository.findByIdUsuario(idUsuario);
		admin = opAdmin.get();
		System.out.println(idUsuario + "Despues de Admin Repository" );
		Mapper mapper = DozerBeanMapperBuilder.buildDefault();
    	adminDTO = ( mapper.map(admin, AdminDTO.class));

		return adminDTO;
	}
	@Override
	public AdminDTO AdminNombre(String nombre) {
			
		AdminDTO adminDTO = new AdminDTO(); 
		Admin admin = null;
		Optional<Admin> opadmin  = adminRepository.findByNombre(nombre);
		admin = opadmin.get();
			
		Mapper mapper = DozerBeanMapperBuilder.buildDefault();
	    adminDTO = ( mapper.map(admin , AdminDTO.class));
		return adminDTO;
	}
	@Override
	public AdminDTO AdminApellidos(String apellidos) {
			
		AdminDTO adminDTO = new AdminDTO(); 
		Admin admin = null;
		Optional<Admin> opadmin  = adminRepository.findByApellidos(apellidos);
		admin = opadmin.get();
			
		Mapper mapper = DozerBeanMapperBuilder.buildDefault();
	    adminDTO = ( mapper.map(admin , AdminDTO.class));
		return adminDTO;
	}
	
	@Override
	public AdminDTO AdminTelefono(String telefono) {
			
		AdminDTO adminDTO = new AdminDTO(); 
		Admin admin = null;
		Optional<Admin> opadmin  = adminRepository.findByTelefono(telefono);
		admin = opadmin.get();
			
		Mapper mapper = DozerBeanMapperBuilder.buildDefault();
	    adminDTO = ( mapper.map(admin , AdminDTO.class));
		return adminDTO;
	}
	@Override
	public void saveAdmin(AdminDTO adminDTO) {
		// TODO Auto-generated method stub
		Admin admin;
		Mapper mapper = DozerBeanMapperBuilder.buildDefault();
		admin = (mapper.map(adminDTO, Admin.class));
    	adminRepository.save(admin);
	}

	@Override
	public void updateAdmin(AdminDTO adminDTO) throws EmptyResultException {
		// TODO Auto-generated method stub
		Admin admin;
		Mapper mapper = DozerBeanMapperBuilder.buildDefault();
		admin = (mapper.map(adminDTO, Admin.class));
		adminRepository.save(admin);
	}

	@Override
	public void deleteAdmin(Long idAdmin) throws EmptyResultException {
		// TODO Auto-generated method stub
		adminRepository.deleteById(idAdmin);
	}

}
