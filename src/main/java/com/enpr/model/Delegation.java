package com.enpr.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Delegation {

	@Id
	@GeneratedValue
    private long id;
	private String libelle_delegation;
	
	@ManyToOne
    @JoinColumn(name="gouvernoratFK")
	private Gouvernorat gouvernorat;
	
	public Gouvernorat getGouvernorat() {
		return gouvernorat;
	}
	public void setGouvernorat(Gouvernorat gouvernorat) {
		this.gouvernorat = gouvernorat;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getLibelle_delegation() {
		return libelle_delegation;
	}
	public void setLibelle_delegation(String libelle_delegation) {
		this.libelle_delegation = libelle_delegation;
	}
	


	
	public Delegation(long id, String libelle_delegation, String codePostal, Gouvernorat gouvernorat) {
		super();
		this.id = id;
		this.libelle_delegation = libelle_delegation;

		this.gouvernorat = gouvernorat;
	}
	
	public Delegation(String libelle_delegation, String codePostal, Gouvernorat gouvernorat) {
		super();
		this.libelle_delegation = libelle_delegation;

		this.gouvernorat = gouvernorat;
	}
	public Delegation(long id) {
		super();
		this.id = id;
	}
	
	
	
	public Delegation() {
		super();
	}

	
	
	
}