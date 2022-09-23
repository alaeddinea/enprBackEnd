package com.enpr.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "vaccineleveTB")
public class VaccinEleve {
	@Id
	@GeneratedValue
    private long id;

	@ManyToOne
    @JoinColumn(name="vaccinFK")
private Vaccin vaccin;
private Date dateVaccin;

@ManyToOne
@JoinColumn(name="eleveFK")
private Eleve eleve;

public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public Vaccin getVaccin() {
	return vaccin;
}

public void setVaccin(Vaccin vaccin) {
	this.vaccin = vaccin;
}

public Date getDateVaccin() {
	return dateVaccin;
}

public void setDateVaccin(Date dateVaccin) {
	this.dateVaccin = dateVaccin;
}

public Eleve getEleve() {
	return eleve;
}

public void setEleve(Eleve eleve) {
	this.eleve = eleve;
}

public VaccinEleve(long id, Vaccin vaccin, Date dateVaccin, Eleve eleve) {
	super();
	this.id = id;
	this.vaccin = vaccin;
	this.dateVaccin = dateVaccin;
	this.eleve = eleve;
}

public VaccinEleve(Vaccin vaccin, Date dateVaccin, Eleve eleve) {
	super();
	this.vaccin = vaccin;
	this.dateVaccin = dateVaccin;
	this.eleve = eleve;
}

public VaccinEleve(long id) {
	super();
	this.id = id;
}

public VaccinEleve() {
	super();
}


}
