package com.enpr.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "medicaleTB")
public class Medicale {
	@Id
	@GeneratedValue
    private long id;
	private String nomMedicale;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNomMedicale() {
		return nomMedicale;
	}
	public void setNomMedicale(String nomMedicale) {
		this.nomMedicale = nomMedicale;
	}
	public Medicale(long id, String nomMedicale) {
		super();
		this.id = id;
		this.nomMedicale = nomMedicale;
	}
	public Medicale(long id) {
		super();
		this.id = id;
	}
	public Medicale(String nomMedicale) {
		super();
		this.nomMedicale = nomMedicale;
	}
	public Medicale() {
		super();
	}
	
}
