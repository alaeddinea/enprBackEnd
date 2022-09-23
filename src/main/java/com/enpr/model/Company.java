package com.enpr.model;




import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "companyTB")
public class Company {
	@Id
	@GeneratedValue
    private long id;
	private int numCompany;
	private String  commandCompany;
	@ManyToOne
    @JoinColumn(name="sessionFK")
	private Session session;
	@ManyToOne
    @JoinColumn(name="groupFK")
	private Group group;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public int getNumCompany() {
		return numCompany;
	}
	public void setNumCompany(int numCompany) {
		this.numCompany = numCompany;
	}
	public String getCommandCompany() {
		return commandCompany;
	}
	public void setCommandCompany(String commandCompany) {
		this.commandCompany = commandCompany;
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
	public Company(long id, int numCompany, String commandCompany, Session session, Group group) {
		super();
		this.id = id;
		this.numCompany = numCompany;
		this.commandCompany = commandCompany;
		this.session = session;
		this.group = group;
	}
	public Company(int numCompany, String commandCompany, Session session, Group group) {
		super();
		this.numCompany = numCompany;
		this.commandCompany = commandCompany;
		this.session = session;
		this.group = group;
	}
	public Company(long id) {
		super();
		this.id = id;
	}

	public Company() {
	
	}

	
}
