package com.bew.demo.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

public class LiberacionExtempDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer idLiberacion;
	private String semestre;
	private Boolean egresado;
	private String registroSS;
	private String prestatario;
	private String programaSS;
	private String fechaInicio;
	private String fechaTermino;
	private String telefono;
	private String estado;
	private String fechaRegistro;
	private String revisado;
	private Integer idAlumno;

	public Integer getIdLiberacion() {
		return idLiberacion;
	}

	public void setIdLiberacion(Integer idLiberacion) {
		this.idLiberacion = idLiberacion;
	}

	public String getSemestre() {
		return semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}

	public Boolean getEgresado() {
		return egresado;
	}

	public void setEgresado(Boolean egresado) {
		this.egresado = egresado;
	}

	public String getRegistroSS() {
		return registroSS;
	}

	public void setRegistroSS(String registroSS) {
		this.registroSS = registroSS;
	}

	public String getPrestatario() {
		return prestatario;
	}

	public void setPrestatario(String prestatario) {
		this.prestatario = prestatario;
	}

	public String getProgramaSS() {
		return programaSS;
	}

	public void setProgramaSS(String programaSS) {
		this.programaSS = programaSS;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getFechaTermino() {
		return fechaTermino;
	}

	public void setFechaTermino(String fechaTermino) {
		this.fechaTermino = fechaTermino;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
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

	public Integer getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(Integer idAlumno) {
		this.idAlumno = idAlumno;
	}
}
