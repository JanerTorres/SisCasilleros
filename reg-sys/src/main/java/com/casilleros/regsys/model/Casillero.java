package com.casilleros.regsys.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Casillero {
	
	
	@Id
	private String id;  // PK
	@Column(name="bloque")
	private int bloque;
	@Column(name="piso")
	private int piso;
	@Column(name="en_prestamo")
	private boolean enPrestamo;
	@Column(name = "reg_prestamo")
	private String regPrestamo;  // FK
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getBloque() {
		return bloque;
	}
	public void setBloque(int bloque) {
		this.bloque = bloque;
	}
	public int getPiso() {
		return piso;
	}
	public void setPiso(int piso) {
		this.piso = piso;
	}
	public boolean isEnPrestamo() {
		return enPrestamo;
	}
	public void setEnPrestamo(boolean enPrestamo) {
		this.enPrestamo = enPrestamo;
	}
	public String getRegPrestamo() {
		return regPrestamo;
	}
	public void setRegPrestamo(String regPrestamo) {
		this.regPrestamo = regPrestamo;
	}
	
	
	
	
}
