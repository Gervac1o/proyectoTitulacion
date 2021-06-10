package com.bew.demo.model;

import java.io.Serializable;
//import java.sql.Date;
//import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="solicitud_baja")
public class SolicitudBaja implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id_solicitud")
	private Long idSolicitud;
	
	@Column(name="tipo_de_baja")
	private String tipoDeBaja;
	
	@Column(name="horas")
	private Integer horas;

	@Column(name="semestre")
	private String semestre;

	@Column(name="egresado")
	private Boolean egresado;

	@Column(name="registro_ss")
	private String registroSS;
	
	@Column(name="prestatario")
	private String prestatario;

	@Column(name="programa_ss")
	private String programaSS;

	@Column(name="fecha_inicio")
	private String fechaInicio;

	@Column(name="fecha_termino")
	private String fechaTermino;
	
	@Column(name="estado")
	private String estado;
	
	@Column(name="fecha_registro")
	private String fechaRegistro;
	
	@Column(name="revisado")
	private String revisado;
	
	@Column(name="id_alumno")
	private Long idAlumno;
	
	public SolicitudBaja() {}
	public SolicitudBaja( Long idSolicitud, String tipoDeBaja, Integer horas, String semestre, Boolean egresado, String registroSS,
	String prestatario, String programaSS, String fechaInicio, String fechaTermino, String estado, String fechaRegistro, String revisado, 
	Long idAlumno) {

		this.idSolicitud=idSolicitud;
		this.tipoDeBaja=tipoDeBaja;
		this.horas=horas;
		this.semestre=semestre;
		this.egresado=egresado;
		this.registroSS=registroSS;
		this.prestatario=prestatario;
		this.programaSS=programaSS;
		this.fechaInicio=fechaInicio;
		this.fechaTermino=fechaTermino;
		this.estado=estado;
		this.fechaRegistro=fechaRegistro;
		this.revisado=revisado;
		this.idAlumno=idAlumno;
}
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_alumno",insertable=false, updatable = false)
	private Alumno alumno;

}
