package com.enpr.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "consultationeleveTB")
public class ConsultationEleve {
	@Id
	@GeneratedValue
    private long id;
	private String typeConsultation;	
	private Date dateConsultation;
	private String remarqueConsultation;
	@ManyToOne
	@JoinColumn(name="eleveFK")
	private Eleve eleve;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTypeConsultation() {
		return typeConsultation;
	}
	public void setTypeConsultation(String typeConsultation) {
		this.typeConsultation = typeConsultation;
	}
	public Date getDateConsultation() {
		return dateConsultation;
	}
	public void setDateConsultation(Date dateConsultation) {
		this.dateConsultation = dateConsultation;
	}
	public String getRemarqueConsultation() {
		return remarqueConsultation;
	}
	public void setRemarqueConsultation(String remarqueConsultation) {
		this.remarqueConsultation = remarqueConsultation;
	}
	public Eleve getEleve() {
		return eleve;
	}
	public void setEleve(Eleve eleve) {
		this.eleve = eleve;
	}
	public ConsultationEleve(long id, String typeConsultation, Date dateConsultation, String remarqueConsultation,
			Eleve eleve) {
		super();
		this.id = id;
		this.typeConsultation = typeConsultation;
		this.dateConsultation = dateConsultation;
		this.remarqueConsultation = remarqueConsultation;
		this.eleve = eleve;
	}
	public ConsultationEleve(String typeConsultation, Date dateConsultation, String remarqueConsultation, Eleve eleve) {
		super();
		this.typeConsultation = typeConsultation;
		this.dateConsultation = dateConsultation;
		this.remarqueConsultation = remarqueConsultation;
		this.eleve = eleve;
	}
	public ConsultationEleve(long id) {
		super();
		this.id = id;
	}
	public ConsultationEleve() {
		super();
	}
	
	}
