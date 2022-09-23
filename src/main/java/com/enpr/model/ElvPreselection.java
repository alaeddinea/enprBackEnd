package com.enpr.model;

import javax.persistence.Entity;

import javax.persistence.Id;
import java.sql.Date;


import javax.persistence.Table;

@Entity
@Table(name = "elv_preselection")
public class ElvPreselection {
	@Id
	private long numdossier;
	private String cod_sexe;
	private String numcin;
	private String prenom;
	private String prenompere;
	private String prenomgp1;
	private String nom;
	private String adresse;
	private Date datenaissance;
	private String prenomdemere;
	private String nomdemere;
	private String lib_lieu_naissance;
	private String telephone;
	private Date dateconv;
	private String gouvernorat;
	private String id_gouvernorat;
	
	public String getId_gouvernorat() {
		return id_gouvernorat;
	}
	public void setId_gouvernorat(String id_gouvernorat) {
		this.id_gouvernorat = id_gouvernorat;
	}
	public String getGouvernorat() {
		return gouvernorat;
	}
	public void setGouvernorat(String gouvernorat) {
		this.gouvernorat = gouvernorat;
	}
	public long getNumdossier() {
		return numdossier;
	}
	public void setNumdossier(long numdossier) {
		this.numdossier = numdossier;
	}
	public String getCod_sexe() {
		return cod_sexe;
	}
	public void setCod_sexe(String cod_sexe) {
		this.cod_sexe = cod_sexe;
	}

	public String getNumcin() {
		return numcin;
	}
	public void setNumcin(String numcin) {
		this.numcin = numcin;
	}
	public String getPrenompere() {
		return prenompere;
	}
	public void setPrenompere(String prenompere) {
		this.prenompere = prenompere;
	}
	public String getPrenomgp1() {
		return prenomgp1;
	}
	public void setPrenomgp1(String prenomgp1) {
		this.prenomgp1 = prenomgp1;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public Date getDatenaissance() {
		return datenaissance;
	}
	public void setDatenaissance(Date datenaissance) {
		this.datenaissance = datenaissance;
	}
	public String getPrenomdemere() {
		return prenomdemere;
	}
	public void setPrenomdemere(String prenomdemere) {
		this.prenomdemere = prenomdemere;
	}
	public String getNomdemere() {
		return nomdemere;
	}
	public void setNomdemere(String nomdemere) {
		this.nomdemere = nomdemere;
	}
	public String getLib_lieu_naissance() {
		return lib_lieu_naissance;
	}
	public void setLib_lieu_naissance(String lib_lieu_naissance) {
		this.lib_lieu_naissance = lib_lieu_naissance;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public Date getDateconv() {
		return dateconv;
	}
	public void setDateconv(Date dateconv) {
		this.dateconv = dateconv;
	}


	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	
	
	public ElvPreselection(long numdossier, String cod_sexe, String numcin, String prenom, String prenompere,
			String prenomgp1, String nom, String adresse, Date datenaissance, String prenomdemere, String nomdemere,
			String lib_lieu_naissance, String telephone, Date dateconv, String gouvernorat, String id_gouvernorat) {
		super();
		this.numdossier = numdossier;
		this.cod_sexe = cod_sexe;
		this.numcin = numcin;
		this.prenom = prenom;
		this.prenompere = prenompere;
		this.prenomgp1 = prenomgp1;
		this.nom = nom;
		this.adresse = adresse;
		this.datenaissance = datenaissance;
		this.prenomdemere = prenomdemere;
		this.nomdemere = nomdemere;
		this.lib_lieu_naissance = lib_lieu_naissance;
		this.telephone = telephone;
		this.dateconv = dateconv;
		this.gouvernorat = gouvernorat;
		this.id_gouvernorat = id_gouvernorat;
	}
	
	
	public ElvPreselection(String cod_sexe, String numcin, String prenom, String prenompere, String prenomgp1,
			String nom, String adresse, Date datenaissance, String prenomdemere, String nomdemere,
			String lib_lieu_naissance, String telephone, Date dateconv, String gouvernorat, String id_gouvernorat) {
		super();
		this.cod_sexe = cod_sexe;
		this.numcin = numcin;
		this.prenom = prenom;
		this.prenompere = prenompere;
		this.prenomgp1 = prenomgp1;
		this.nom = nom;
		this.adresse = adresse;
		this.datenaissance = datenaissance;
		this.prenomdemere = prenomdemere;
		this.nomdemere = nomdemere;
		this.lib_lieu_naissance = lib_lieu_naissance;
		this.telephone = telephone;
		this.dateconv = dateconv;
		this.gouvernorat = gouvernorat;
		this.id_gouvernorat = id_gouvernorat;
	}
	public ElvPreselection(long numdossier) {
		super();
		this.numdossier = numdossier;
	}
	public ElvPreselection() {
		super();
	}
	
	
	
	}
