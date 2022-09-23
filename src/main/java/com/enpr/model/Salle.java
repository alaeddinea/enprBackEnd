package com.enpr.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "salleTB")
public class Salle {
	@Id
	@GeneratedValue
    private long id;
	private String nomSalle;
	private long capaciteSalle;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNomSalle() {
		return nomSalle;
	}
	public void setNomSalle(String nomSalle) {
		this.nomSalle = nomSalle;
	}
	public long getCapaciteSalle() {
		return capaciteSalle;
	}
	public void setCapaciteSalle(long capaciteSalle) {
		this.capaciteSalle = capaciteSalle;
	}
	public Salle(long id, String nomSalle, long capaciteSalle) {
		super();
		this.id = id;
		this.nomSalle = nomSalle;
		this.capaciteSalle = capaciteSalle;
	}
	public Salle(String nomSalle, long capaciteSalle) {
		super();
		this.nomSalle = nomSalle;
		this.capaciteSalle = capaciteSalle;
	}
	public Salle(long id) {
		super();
		this.id = id;
	}
	public Salle() {
		super();
	}
	
}
