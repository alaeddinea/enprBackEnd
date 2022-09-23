package com.enpr.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "regimeB")
public class Regime {
	@Id
	@GeneratedValue
    private long id;
	private String nomRegime;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNomRegime() {
		return nomRegime;
	}
	public void setNomRegime(String nomRegime) {
		this.nomRegime = nomRegime;
	}
	public Regime(long id, String nomRegime) {
		super();
		this.id = id;
		this.nomRegime = nomRegime;
	}
	public Regime(long id) {
		super();
		this.id = id;
	}
	public Regime(String nomRegime) {
		super();
		this.nomRegime = nomRegime;
	}
	public Regime() {
		super();
	}
	
	
}
