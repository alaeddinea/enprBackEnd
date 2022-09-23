package com.enpr.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Gouvernorat {
	
	@Id
	@GeneratedValue
    private long id;
	


    private String libelle_gouvernorat;
    
  
	public Gouvernorat(long id,  String libelle_gouvernorat) {
		super();
		this.id = id;

		this.libelle_gouvernorat = libelle_gouvernorat;
	}
 





	public long getId() {
		return id;
	}






	public void setId(long id) {
		this.id = id;
	}







	public String getLibelle_gouvernorat() {
		return libelle_gouvernorat;
	}

	public void setLibelle_gouvernorat(String libelle_gouvernorat) {
		this.libelle_gouvernorat = libelle_gouvernorat;
	}

	public Gouvernorat( String libelle_gouvernorat) {
		super();
		this.libelle_gouvernorat = libelle_gouvernorat;
	}

	public Gouvernorat(long id) {
		super();
		this.id = id;
	}






	public Gouvernorat() {
		super();
		// TODO Auto-generated constructor stub
	}


    
    
}
