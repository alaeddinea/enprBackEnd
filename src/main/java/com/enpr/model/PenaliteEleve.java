package com.enpr.model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "penaliteEleve_table")
public class PenaliteEleve {
		@Id
		@GeneratedValue
	    private long id;
	
		@ManyToOne
	    @JoinColumn(name="penaliteFK")
	private Penalite penalite;
	private Date dateDebutPenalite;
	private Date dateFinPenalite;
	@ManyToOne
    @JoinColumn(name="eleveFK")
	private Eleve eleve;
	public Penalite getPenalite() {
		return penalite;
	}
	public void setPenalite(Penalite penalite) {
		this.penalite = penalite;
	}
	public Date getDateDebutPenalite() {
		return dateDebutPenalite;
	}
	public void setDateDebutPenalite(Date dateDebutPenalite) {
		this.dateDebutPenalite = dateDebutPenalite;
	}
	public Date getDateFinPenalite() {
		return dateFinPenalite;
	}
	public void setDateFinPenalite(Date dateFinPenalite) {
		this.dateFinPenalite = dateFinPenalite;
	}
	public Eleve getEleve() {
		return eleve;
	}
	public void setEleve(Eleve eleve) {
		this.eleve = eleve;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	
	public PenaliteEleve(long id, Penalite penalite, Date dateDebutPenalite, Date dateFinPenalite, Eleve eleve) {
		super();
		this.id = id;
		this.penalite = penalite;
		this.dateDebutPenalite = dateDebutPenalite;
		this.dateFinPenalite = dateFinPenalite;
		this.eleve = eleve;
	}
	public PenaliteEleve(Penalite penalite, Date dateDebutPenalite, Date dateFinPenalite, Eleve eleve) {
		super();
		this.penalite = penalite;
		this.dateDebutPenalite = dateDebutPenalite;
		this.dateFinPenalite = dateFinPenalite;
		this.eleve = eleve;
	}
	public PenaliteEleve(long id) {
		super();
		this.id = id;
	}
	public PenaliteEleve() {
		super();
	}
	@Override
	public String toString() {
		return "PenaliteEleve [id=" + id + ", penalite=" + penalite + ", dateDebutPenalite=" + dateDebutPenalite
				+ ", dateFinPenalite=" + dateFinPenalite + ", eleve=" + eleve + "]";
	}
	
	
	

}
