package com.bew.demo.dto;



import java.io.Serializable;

public class SolicitudBajaDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Long idSolicitud;
	private String tipoDeBaja;
	private Integer horas;
	private String semestre;
	private Boolean egresado;
	private String registroSS;
	private String prestatario;
	private String programaSS;
	private String fechaInicio;
	private String fechaTermino;
	private String estado;
	private String fechaRegistro;
	private String revisado;
	private Long idAlumno;

	
	
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

	public Long getIdSolicitud() {
		return idSolicitud;
	}

	public void setIdSolicitud(Long idSolicitud) {
		this.idSolicitud = idSolicitud;
	}

	public String getTipoDeBaja() {
		return tipoDeBaja;
	}

	public void setTipoDeBaja(String tipoDeBaja) {
		this.tipoDeBaja = tipoDeBaja;
	}

	public Integer getHoras() {
		return horas;
	}

	public void setHoras(Integer horas) {
		this.horas = horas;
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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
}
