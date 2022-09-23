package com.enpr.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "specialiteTB")
public class Specialite {
	
	@Id
	@GeneratedValue
    private long id;
	private String code_specialite;
	private String libelle_specialite;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getLibelle_specialite() {
		return libelle_specialite;
	}
	public void setLibelle_specialite(String libelle_specialite) {
		this.libelle_specialite = libelle_specialite;
	}

	public String getCode_specialite() {
		return code_specialite;
	}
	public void setCode_specialite(String code_specialite) {
		this.code_specialite = code_specialite;
	}
	public Specialite(long id) {
		super();
		this.id = id;
	}
	public Specialite() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Specialite(long id, String code_specialite, String libelle_specialite) {
		super();
		this.id = id;
		this.code_specialite = code_specialite;
		this.libelle_specialite = libelle_specialite;
	}
	public Specialite(String code_specialite, String libelle_specialite) {
		super();
		this.code_specialite = code_specialite;
		this.libelle_specialite = libelle_specialite;
	}
	
	
    
}
