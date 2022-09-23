package com.enpr.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "administrationTB")
public class Administration {
	@Id
	@GeneratedValue
    private long id;
	private String nomAdministration;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNomAdministration() {
		return nomAdministration;
	}
	public void setNomAdministration(String nomAdministration) {
		this.nomAdministration = nomAdministration;
	}
	public Administration(long id, String nomAdministration) {
		super();
		this.id = id;
		this.nomAdministration = nomAdministration;
	}
	public Administration(long id) {
		super();
		this.id = id;
	}
	public Administration(String nomAdministration) {
		super();
		this.nomAdministration = nomAdministration;
	}
	public Administration() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
