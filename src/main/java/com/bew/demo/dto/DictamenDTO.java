package com.bew.demo.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

public class DictamenDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Float porcentajeCreditos;
	private String semestre;
	private Long idDictamen;
	private String estado;
	private String fechaRegistro;
	private String revisado;
	private Long idAlumno;

	public Float getPorcentajeCreditos() {
		return porcentajeCreditos;
	}

	public void setPorcentajeCreditos(Float porcentajeCreditos) {
		this.porcentajeCreditos = porcentajeCreditos;
	}

	public String getSemestre() {
		return semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}

	public Long getIdDictamen() {
		return idDictamen;
	}

	public void setIdDictamen(Long idDictamen) {
		this.idDictamen = idDictamen;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(String fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getRevisado() {
		return revisado;
	}

	public void setRevisado(String revisado) {
		this.revisado = revisado;
	}

	public Long getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(Long idAlumno) {
		this.idAlumno = idAlumno;
	}




}
