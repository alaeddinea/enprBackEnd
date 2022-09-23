package com.enpr.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Fonction {
	@Id
	@GeneratedValue
    private long id;
    private String libelle_fonction;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getLibelle_fonction() {
		return libelle_fonction;
	}
	public void setLibelle_fonction(String libelle_fonction) {
		this.libelle_fonction = libelle_fonction;
	}
	public Fonction(long id, String libelle_fonction) {
		super();
		this.id = id;
		this.libelle_fonction = libelle_fonction;
	}
	public Fonction(long id) {
		super();
		this.id = id;
	}
	public Fonction(String libelle_fonction) {
		super();
		this.libelle_fonction = libelle_fonction;
	}
	public Fonction() {
		super();
	}
    
}
