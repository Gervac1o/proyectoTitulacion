package com.bew.demo.dto;

import lombok.Getter;

import lombok.Setter;

import java.io.Serializable;

public class AdminDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Long idAdmin;
	private String nombre;
	private String apellidos;
	private String telefono;
	private Long idUsuario;


	public Long getIdAdmin() {
		return idAdmin;
	}

	public void setIdAdmin(Long idAdmin) {
		this.idAdmin = idAdmin;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
}
