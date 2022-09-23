package com.enpr.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "etatcivilTB")
public class Etatcivil {
	@Id
	@GeneratedValue
    private long id;
	private String code_etatcivil;
	private String libelle_etatcivil;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCode_etatcivil() {
		return code_etatcivil;
	}
	public void setCode_etatcivil(String code_etatcivil) {
		this.code_etatcivil = code_etatcivil;
	}
	public String getLibelle_etatcivil() {
		return libelle_etatcivil;
	}
	public void setLibelle_etatcivil(String libelle_etatcivil) {
		this.libelle_etatcivil = libelle_etatcivil;
	}
	public Etatcivil(long id, String code_etatcivil, String libelle_etatcivil) {
		super();
		this.id = id;
		this.code_etatcivil = code_etatcivil;
		this.libelle_etatcivil = libelle_etatcivil;
	}
	public Etatcivil(String code_etatcivil, String libelle_etatcivil) {
		super();
		this.code_etatcivil = code_etatcivil;
		this.libelle_etatcivil = libelle_etatcivil;
	}
	public Etatcivil(long id) {
		super();
		this.id = id;
	}
	public Etatcivil() {
		super();
	}
	
}
