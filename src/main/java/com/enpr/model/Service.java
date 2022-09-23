package com.enpr.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "serviceB")
public class Service {
	@Id
	@GeneratedValue
    private long id;
	private String nomService;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNomService() {
		return nomService;
	}
	public void setNomService(String nomService) {
		this.nomService = nomService;
	}
	public Service(long id, String nomService) {
		super();
		this.id = id;
		this.nomService = nomService;
	}
	public Service(long id) {
		super();
		this.id = id;
	}
	public Service(String nomService) {
		super();
		this.nomService = nomService;
	}
	public Service() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
