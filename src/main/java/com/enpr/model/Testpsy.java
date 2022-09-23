package com.enpr.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "testpsyTB")
public class Testpsy {
	@Id
	@GeneratedValue
    private long id;
	private String nomTestpsy;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNomTestpsy() {
		return nomTestpsy;
	}
	public void setNomTestpsy(String nomTestpsy) {
		this.nomTestpsy = nomTestpsy;
	}
	public Testpsy(long id, String nomTestpsy) {
		super();
		this.id = id;
		this.nomTestpsy = nomTestpsy;
	}
	
	
	
	public Testpsy(long id) {
		super();
		this.id = id;
	}
	public Testpsy(String nomTestpsy) {
		super();
		this.nomTestpsy = nomTestpsy;
	}
	public Testpsy() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
