package com.enpr.model;




import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "groupTB")
public class Group {
	@Id
	@GeneratedValue
    private long id;

	private String nomGroup;
	private String commandGroup;
	@ManyToOne
    @JoinColumn(name="sessionFK")
	private Session session;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNomGroup() {
		return nomGroup;
	}
	public void setNomGroup(String nomGroup) {
		this.nomGroup = nomGroup;
	}
	public Session getSession() {
		return session;
	}
	public void setSession(Session session) {
		this.session = session;
	}
	
	
	public String getCommandGroup() {
		return commandGroup;
	}
	public void setCommandGroup(String commandGroup) {
		this.commandGroup = commandGroup;
	}
	
	
	public Group(long id, String nomGroup, String commandGroup, Session session) {
		super();
		this.id = id;
		this.nomGroup = nomGroup;
		this.commandGroup = commandGroup;
		this.session = session;
	}
	
	public Group(String nomGroup, String commandGroup, Session session) {
		super();
		this.nomGroup = nomGroup;
		this.commandGroup = commandGroup;
		this.session = session;
	}
	public Group(String nomGroup, Session session) {
		super();
		this.nomGroup = nomGroup;
		this.session = session;
	}
	public Group(long id) {
		super();
		this.id = id;
	}
	
	public Group() {
		
	
	}
	@Override
	public String toString() {
		return "Group [id=" + id + ", nomGroup=" + nomGroup + ", commandGroup=" + commandGroup + ", session=" + session
				+ "]";
	}
	
}
