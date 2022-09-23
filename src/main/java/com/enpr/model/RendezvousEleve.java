package com.enpr.model;

import java.util.Date;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "rendezvouseleveTB")
public class RendezvousEleve {
	@Id
	@GeneratedValue
    private long id;
	private String typeRendezvous;	
	private Date dateRendezvous;
	//private Time timeRendezvous;
	private String remarqueRendezvous;
	@ManyToOne
	@JoinColumn(name="eleveFK")
	private Eleve eleve;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTypeRendezvous() {
		return typeRendezvous;
	}
	public void setTypeRendezvous(String typeRendezvous) {
		this.typeRendezvous = typeRendezvous;
	}
	public Date getDateRendezvous() {
		return dateRendezvous;
	}
	public void setDateRendezvous(Date dateRendezvous) {
		this.dateRendezvous = dateRendezvous;
	}
	public String getRemarqueRendezvous() {
		return remarqueRendezvous;
	}
	public void setRemarqueRendezvous(String remarqueRendezvous) {
		this.remarqueRendezvous = remarqueRendezvous;
	}
	public Eleve getEleve() {
		return eleve;
	}
	public void setEleve(Eleve eleve) {
		this.eleve = eleve;
	}

	/*public Time getTimeRendezvous() {
		return timeRendezvous;
	}
	public void setTimeRendezvous(Time timeRendezvous) {
		this.timeRendezvous = timeRendezvous;
	}*/
	public RendezvousEleve(long id) {
		super();
		this.id = id;
	}
	public RendezvousEleve() {
		super();
	}
	public RendezvousEleve(long id, String typeRendezvous, Date dateRendezvous, 
			String remarqueRendezvous, Eleve eleve) {
		super();
		this.id = id;
		this.typeRendezvous = typeRendezvous;
		this.dateRendezvous = dateRendezvous;
	//	this.timeRendezvous = timeRendezvous;
		this.remarqueRendezvous = remarqueRendezvous;
		this.eleve = eleve;
	}
	public RendezvousEleve(String typeRendezvous, Date dateRendezvous,String remarqueRendezvous,
			Eleve eleve) {
		super();
		this.typeRendezvous = typeRendezvous;
		this.dateRendezvous = dateRendezvous;
		//this.timeRendezvous = timeRendezvous;
		this.remarqueRendezvous = remarqueRendezvous;
		this.eleve = eleve;
	}
	@Override
	public String toString() {
		return "RendezvousEleve [id=" + id + ", typeRendezvous=" + typeRendezvous + ", dateRendezvous=" + dateRendezvous
				+ ", remarqueRendezvous=" + remarqueRendezvous + "]";
	}
	
	
}
