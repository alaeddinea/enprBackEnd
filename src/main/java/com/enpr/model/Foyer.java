package com.enpr.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "foyerTB")
public class Foyer {
	@Id
	@GeneratedValue
    private long id;
	private String nomFoyer;
	private long capaciteFoyer;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNomFoyer() {
		return nomFoyer;
	}
	public void setNomFoyer(String nomFoyer) {
		this.nomFoyer = nomFoyer;
	}
	public long getCapaciteFoyer() {
		return capaciteFoyer;
	}
	public void setCapaciteFoyer(long capaciteFoyer) {
		this.capaciteFoyer = capaciteFoyer;
	}
	public Foyer(long id, String nomFoyer, long capaciteFoyer) {
		super();
		this.id = id;
		this.nomFoyer = nomFoyer;
		this.capaciteFoyer = capaciteFoyer;
	}
	public Foyer(String nomFoyer, long capaciteFoyer) {
		super();
		this.nomFoyer = nomFoyer;
		this.capaciteFoyer = capaciteFoyer;
	}
	public Foyer(long id) {
		super();
		this.id = id;
	}
	public Foyer() {
		super();
	}
	
	
}
