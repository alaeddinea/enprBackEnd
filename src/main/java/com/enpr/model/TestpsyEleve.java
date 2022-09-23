package com.enpr.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "testpsyeleveTB")
public class TestpsyEleve {
	@Id
	@GeneratedValue
    private long id;

	@ManyToOne
    @JoinColumn(name="testpsyFK")
	private Testpsy testpsy ;
private Date dateTestpsy;
private String  remarque;

@ManyToOne
@JoinColumn(name="eleveFK")
private Eleve eleve;

public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public Testpsy getTestpsy() {
	return testpsy;
}

public void setTestpsy(Testpsy testpsy) {
	this.testpsy = testpsy;
}

public Date getDateTestpsy() {
	return dateTestpsy;
}

public void setDateTestpsy(Date dateTestpsy) {
	this.dateTestpsy = dateTestpsy;
}

public String getRemarque() {
	return remarque;
}

public void setRemarque(String remarque) {
	this.remarque = remarque;
}

public Eleve getEleve() {
	return eleve;
}

public void setEleve(Eleve eleve) {
	this.eleve = eleve;
}

public TestpsyEleve(long id, Testpsy testpsy, Date dateTestpsy, String remarque, Eleve eleve) {
	super();
	this.id = id;
	this.testpsy = testpsy;
	this.dateTestpsy = dateTestpsy;
	this.remarque = remarque;
	this.eleve = eleve;
}

public TestpsyEleve(Testpsy testpsy, Date dateTestpsy, String remarque, Eleve eleve) {
	super();
	this.testpsy = testpsy;
	this.dateTestpsy = dateTestpsy;
	this.remarque = remarque;
	this.eleve = eleve;
}

public TestpsyEleve(long id) {
	super();
	this.id = id;
}

public TestpsyEleve() {
	super();
	// TODO Auto-generated constructor stub
}




}
