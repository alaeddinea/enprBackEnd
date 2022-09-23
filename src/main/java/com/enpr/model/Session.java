package com.enpr.model;


import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "sessionTB")
public class Session {
	@Id
	@GeneratedValue
    private long id;
	private int numSession;
	private String nomSession;
	private String  etatSession ;
	private Date dtOvSession;
	private Date dtFrSession;
	@OneToMany
	private List<Group> groups;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getNumSession() {
		return numSession;
	}
	public void setNumSession(int numSession) {
		this.numSession = numSession;
	}
	public String getNomSession() {
		return nomSession;
	}
	public void setNomSession(String nomSession) {
		this.nomSession = nomSession;
	}
	public String getEtatSession() {
		return etatSession;
	}
	public void setEtatSession(String etatSession) {
		this.etatSession = etatSession;
	}
	public Date getDtOvSession() {
		return dtOvSession;
	}
	public void setDtOvSession(Date dtOvSession) {
		this.dtOvSession = dtOvSession;
	}
	public Date getDtFrSession() {
		return dtFrSession;
	}
	public void setDtFrSession(Date dtFrSession) {
		this.dtFrSession = dtFrSession;
	}
	public Session(long id, int numSession, String nomSession, String etatSession, Date dtOvSession, Date dtFrSession) {
		super();
		this.id = id;
		this.numSession = numSession;
		this.nomSession = nomSession;
		this.etatSession = etatSession;
		this.dtOvSession = dtOvSession;
		this.dtFrSession = dtFrSession;
	}
	
	public Session(int numSession, String nomSession, String etatSession, Date dtOvSession, Date dtFrSession) {
		super();
		this.numSession = numSession;
		this.nomSession = nomSession;
		this.etatSession = etatSession;
		this.dtOvSession = dtOvSession;
		this.dtFrSession = dtFrSession;
	}
	
	public Session(long id) {
	
		this.id = id;
	}
	public Session() {
		
	}
	@Override
	public String toString() {
		return "Session [id=" + id + ", numSession=" + numSession + ", nomSession=" + nomSession + ", etatSession="
				+ etatSession + ", dtOvSession=" + dtOvSession + ", dtFrSession=" + dtFrSession + ", groups=" + groups
				+ "]";
	}
	
	
}
