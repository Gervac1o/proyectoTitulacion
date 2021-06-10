package com.bew.demo.model;

import java.io.Serializable;

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
@Table(name="servicio_social")
public class ServicioSocial implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id_servicio")
	private Long idServicio;

	@Column(name="semestre")
	private String semestre;

	@Column(name="responsable_directo")
	private String responsableDirecto;
	
	@Column(name="estado")
	private String estado;
	
	@Column(name="fecha_registro")
	private String fechaRegistro;
	
	@Column(name="revisado")
	private String revisado;
	
	@Column(name="id_alumno")
	private Long idAlumno;

	public ServicioSocial() {}
	public ServicioSocial( Long idServicio, String semestre, String responsableDirecto, String estado,
			String fechaRegistro, String revisado, Long idAlumno) {

		this.idServicio=idServicio;
		this.semestre=semestre;
		this.responsableDirecto=responsableDirecto;
		this.estado=estado;
		this.fechaRegistro=fechaRegistro;
		this.revisado=revisado;
		this.idAlumno=idAlumno;
}
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_alumno",insertable=false, updatable = false)
	private Alumno alumno;
}
