package com.enpr.model;


import java.sql.Blob;
import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

 

@Entity 
public class Personelle {
	@Id
	@GeneratedValue
    private long id;
private long matricule; 
private String cnrps; 
private String nom; 
private String prenom; 
private String nom_pere; 
private Date date_retraite; 
@Lob
@Basic(fetch = FetchType.LAZY)
@Column(name="img", length = 1000)
private byte[] img;

 




//public Blob getImg() {
//	return img;
//}
//
//
//
//public void setImg(Blob img) {
//	this.img = img;
//}


 





























public byte[] getImg() {
	return img;
}



public void setImg(byte[] img) {
	this.img = img;
}





 


public Personelle(long id) {
	super();
	this.id = id;
}
public Personelle() {
	super();
	// TODO Auto-generated constructor stub
}



public long getId() {
	return id;
}



public void setId(long id) {
	this.id = id;
}



public long getMatricule() {
	return matricule;
}



public void setMatricule(long matricule) {
	this.matricule = matricule;
}



public String getCnrps() {
	return cnrps;
}



public void setCnrps(String cnrps) {
	this.cnrps = cnrps;
}



public String getNom() {
	return nom;
}



public void setNom(String nom) {
	this.nom = nom;
}



public String getPrenom() {
	return prenom;
}



public void setPrenom(String prenom) {
	this.prenom = prenom;
}



public String getNom_pere() {
	return nom_pere;
}



public void setNom_pere(String nom_pere) {
	this.nom_pere = nom_pere;
}



public Date getDate_retraite() {
	return date_retraite;
}



public void setDate_retraite(Date date_retraite) {
	this.date_retraite = date_retraite;
}



 












public Personelle(long id, long matricule, String cnrps, String nom, String prenom, String nom_pere, Date date_retraite,
		byte[] img) {
	super();
	this.id = id;
	this.matricule = matricule;
	this.cnrps = cnrps;
	this.nom = nom;
	this.prenom = prenom;
	this.nom_pere = nom_pere;
	this.date_retraite = date_retraite;
	this.img = img;


}



public Personelle(long matricule, String cnrps, String nom, String prenom, String nom_pere, Date date_retraite,
		byte[] img) {
	super();
	this.matricule = matricule;
	this.cnrps = cnrps;
	this.nom = nom;
	this.prenom = prenom;
	this.nom_pere = nom_pere;
	this.date_retraite = date_retraite;
	this.img = img;

}



@Override
public String toString() {
	return "Personelle [id=" + id + ", matricule=" + matricule + ", cnrps=" + cnrps + ", nom=" + nom + ", prenom="
			+ prenom + ", nom_pere=" + nom_pere + ", date_retraite=" + date_retraite + ", img=" + Arrays.toString(img)
			+ "]";
}







}