package com.enpr.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "repoeleveTB")
public class RepoEleve {
	@Id
	@GeneratedValue
    private long id;

	@ManyToOne
    @JoinColumn(name="medicaleFK")
	private Medicale medicale;
private Date dateDebutRepo;
private Date dateFinRepo;

@ManyToOne
@JoinColumn(name="eleveFK")
private Eleve eleve;

public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public Medicale getMedicale() {
	return medicale;
}

public void setMedicale(Medicale medicale) {
	this.medicale = medicale;
}

public Date getDateDebutRepo() {
	return dateDebutRepo;
}

public void setDateDebutRepo(Date dateDebutRepo) {
	this.dateDebutRepo = dateDebutRepo;
}

public Date getDateFinRepo() {
	return dateFinRepo;
}

public void setDateFinRepo(Date dateFinRepo) {
	this.dateFinRepo = dateFinRepo;
}

public Eleve getEleve() {
	return eleve;
}

public void setEleve(Eleve eleve) {
	this.eleve = eleve;
}

public RepoEleve(long id, Medicale medicale, Date dateDebutRepo, Date dateFinRepo, Eleve eleve) {
	super();
	this.id = id;
	this.medicale = medicale;
	this.dateDebutRepo = dateDebutRepo;
	this.dateFinRepo = dateFinRepo;
	this.eleve = eleve;
}

public RepoEleve(Medicale medicale, Date dateDebutRepo, Date dateFinRepo, Eleve eleve) {
	super();
	this.medicale = medicale;
	this.dateDebutRepo = dateDebutRepo;
	this.dateFinRepo = dateFinRepo;
	this.eleve = eleve;
}

public RepoEleve(long id) {
	super();
	this.id = id;
}

public RepoEleve() {
	super();
}


}
