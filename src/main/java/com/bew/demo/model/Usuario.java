package com.bew.demo.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="usuario")
public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "usuario_sec", sequenceName = "usuario_seq", allocationSize = 1, initialValue=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_sec")
	@Column(name="id_usuario")
	private Long idUsuario;
	
	@Column(name="email", unique = true)
	private String email;
	
	@Column(name="password")
	private String password;
	
	@Column(name="password2")
	private String password2;

	@Column(name="tipo_usuario")
	private Boolean tipoUsuario;
	
	@Column(name = "status")
	private Boolean status;
	
	public Usuario() {}
	public Usuario( Long idUsuario, String email, String password, Boolean tipoUsuario, Boolean status, String password2) {
		 	
		this.idUsuario=idUsuario;
		this.email=email;
		this.password=password;
		this.password2=password2;
		this.tipoUsuario=tipoUsuario;
		this.status = status;
		
	}
	public Long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	public String getPassword2() {
		return password2;
	}

	public Boolean getTipoUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(Boolean tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}

	
}
