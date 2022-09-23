package com.enpr.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Grade {
	@Id
	@GeneratedValue
    private long id;
   
	private String categorieGrade;
    private String libelle_grade;

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCategorieGrade() {
		return categorieGrade;
	}

	public void setCategorieGrade(String categorieGrade) {
		this.categorieGrade = categorieGrade;
	}

	public String getLibelle_grade() {
		return libelle_grade;
	}

	public void setLibelle_grade(String libelle_grade) {
		this.libelle_grade = libelle_grade;
	}


	public Grade() {
	
	}

	public Grade(long id, String categorieGrade, String libelle_grade) {
		super();
		this.id = id;
		this.categorieGrade = categorieGrade;
		this.libelle_grade = libelle_grade;
	}

	public Grade(String categorieGrade, String libelle_grade) {
		super();
		this.categorieGrade = categorieGrade;
		this.libelle_grade = libelle_grade;
	}

	public Grade(long id) {
		super();
		this.id = id;
	}

	


}
