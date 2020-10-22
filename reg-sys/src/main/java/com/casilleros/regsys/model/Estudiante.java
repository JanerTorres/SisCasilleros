package com.casilleros.regsys.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Estudiante {
	
	@Id
	private String id;  // PK
	@Column(name="nombres")
	private String nombres;
	@Column(name="apellidos")
	private String apellidos;
	@Column(name="facultad")
	private String facultad;
	@Column(name="programa")
	private String programa;
	@Column(name = "estado_ac")
	private String estadoAc;
	@Column(name="correo")
	private String correo;
	@Column(name="password")
	private String password;
	@Column(name="prestamo_vig")
	private boolean prestamoVig;
	@Column(name = "reg_prestamo")
	private String regPrestamo; // FK
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getFacultad() {
		return facultad;
	}
	public void setFacultad(String facultad) {
		this.facultad = facultad;
	}
	public String getPrograma() {
		return programa;
	}
	public void setPrograma(String programa) {
		this.programa = programa;
	}
	public String getEstadoAc() {
		return estadoAc;
	}
	public void setEstadoAc(String estadoAc) {
		this.estadoAc = estadoAc;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isPrestamoVig() {
		return prestamoVig;
	}
	public void setPrestamoVig(boolean prestamoVig) {
		this.prestamoVig = prestamoVig;
	}
	public String getRegPrestamo() {
		return regPrestamo;
	}
	public void setRegPrestamo(String regPrestamo) {
		this.regPrestamo = regPrestamo;
	}
	
	

}
