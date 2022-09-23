package com.enpr.model;


import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "sectionTB")
public class Section {
	@Id
	@GeneratedValue
    private long id;
	private int numSection;
	private String commandSection;
	@ManyToOne
    @JoinColumn(name="sessionFK")
	private Session session;
	@ManyToOne
    @JoinColumn(name="groupFK")
	private Group group;
	@ManyToOne
    @JoinColumn(name="companyFK")
	private Company company;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getNumSection() {
		return numSection;
	}
	public void setNumSection(int numSection) {
		this.numSection = numSection;
	}
	public String getCommandSection() {
		return commandSection;
	}
	public void setCommandSection(String commandSection) {
		this.commandSection = commandSection;
	}
	public Session getSession() {
		return session;
	}
	public void setSession(Session session) {
		this.session = session;
	}
	public Group getGroup() {
		return group;
	}
	public void setGroup(Group group) {
		this.group = group;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public Section(long id, int numSection, String commandSection, Session session, Group group, Company company) {
		super();
		this.id = id;
		this.numSection = numSection;
		this.commandSection = commandSection;
		this.session = session;
		this.group = group;
		this.company = company;
	}
	public Section(int numSection, String commandSection, Session session, Group group, Company company) {
		super();
		this.numSection = numSection;
		this.commandSection = commandSection;
		this.session = session;
		this.group = group;
		this.company = company;
	}
	public Section(long id) {
		super();
		this.id = id;
	}
	public Section() {
		
	}
	
}
