package com.enpr.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vaccinTB")
public class Vaccin {
	@Id
	@GeneratedValue
    private long id;
	private String nomVaccin;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNomVaccin() {
		return nomVaccin;
	}
	public void setNomVaccin(String nomVaccin) {
		this.nomVaccin = nomVaccin;
	}
	public Vaccin(long id, String nomVaccin) {
		super();
		this.id = id;
		this.nomVaccin = nomVaccin;
	}
	public Vaccin(long id) {
		super();
		this.id = id;
	}
	public Vaccin(String nomVaccin) {
		super();
		this.nomVaccin = nomVaccin;
	}
	public Vaccin() {
		super();
	}
	
}
