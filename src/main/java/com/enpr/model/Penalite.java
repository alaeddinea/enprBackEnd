package com.enpr.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "penaliteTB")
public class Penalite {
	@Id
	@GeneratedValue
    private long id;
	private String nomPenalite;
	private String typePenalite;
	public String getTypePenalite() {
		return typePenalite;
	}
	public void setTypePenalite(String typePenalite) {
		this.typePenalite = typePenalite;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNomPenalite() {
		return nomPenalite;
	}
	public void setNomPenalite(String nomPenalite) {
		this.nomPenalite = nomPenalite;
	}
	public Penalite(long id, String nomPenalite,String typePenalite) {
		super();
		this.id = id;
		this.nomPenalite = nomPenalite;
		this.typePenalite = typePenalite;
	}
	public Penalite(long id) {
		super();
		this.id = id;
	}
	public Penalite(String nomPenalite,String typePenalite) {
		super();
		this.nomPenalite = nomPenalite;
		this.typePenalite = typePenalite;
	}
	public Penalite() {
		super();
	}
	
}
