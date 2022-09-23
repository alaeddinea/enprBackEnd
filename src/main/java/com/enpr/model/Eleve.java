package com.enpr.model;
import java.sql.Date;
import java.sql.Time;
import java.util.Arrays;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

@Entity
@Table(name = "eleveTB")
public class Eleve {
	@Id
	@GeneratedValue
	    private long id;
	
	@Lob
	@Basic(fetch = FetchType.LAZY)
	@Column(name="img", length = 1000)
	private byte[] img;
	
		private Long cinEl;
		private Date dateCinEl;
		private String prenomEl;
		private String nomEl;
		private Date datenaissanceEl;
		private String lieuNaissanceEl;
		private String mailEl;
		private String telFamilleEl;
		private String fixeFamilleEl;
		private String telEl;
		private byte[] imageEl;
		private String fileName;
		
		private Date datenterEl;
		private Time timeEnterEl;
		private String sexeEl;
	private Long numDossierRecrueEl;
	private String categorie;
	@ManyToOne
    @JoinColumn(name="gradeFK")
	private Grade  grade; 
	@ManyToOne
    @JoinColumn(name="specialiteFK")
	private Specialite  specialite; 
	@ManyToOne
    @JoinColumn(name="etatcivilFK")
	private Etatcivil etatcivil  ; 
	@ManyToOne
    @JoinColumn(name="gouvernoratFK")
		private Gouvernorat gouvernorat= new Gouvernorat(); 
	@ManyToOne
    @JoinColumn(name="delegationFK")
		private Delegation delegation=null; 	
		private String rueEl;
		private String codePostaleEl;
		private String zonePoliceEl;
		private String centralPoliceEl;
	private String nivScolaireEl;	
	private String diplomeEl;
	private String stagesEl;
		private String etatMilitaireEl; 
		private String passionEl;
		private String activiteSportifEl;
		private String associationEl;
	private String identitePereEl;
	private String identiteMereEl;
	private String fonctionPereEl;
	private String societePereEl;
	
	//@OneToOne(cascade = {CascadeType.ALL})
	private long imageModelId;
	

	public Etatcivil getEtatcivil() {
		return etatcivil;
	}
	public void setEtatcivil(Etatcivil etatcivil) {
		this.etatcivil = etatcivil;
	}
	public long getImageModelId() {
		return imageModelId;
	}
	public void setImageModelId(long imageModelId) {
		this.imageModelId = imageModelId;
	}
	@ManyToOne
    @JoinColumn(name="sessionFK")
	private Session session=null;
	
	@ManyToOne
    @JoinColumn(name="groupFK")
	private Group group=null; 
	
	@ManyToOne
    @JoinColumn(name="companyFK")
	private Company company=null; 
	
	@ManyToOne
    @JoinColumn(name="sectionFK")
	private Section section=null; 
	
	public byte[] getImg() {
		return img;
	}


	public void setImg(byte[] img) {
		this.img = img;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Long getCinEl() {
		return cinEl;
	}
	public void setCinEl(Long cinEl) {
		this.cinEl = cinEl;
	}
	public Date getDateCinEl() {
		return dateCinEl;
	}
	public void setDateCinEl(Date dateCinEl) {
		this.dateCinEl = dateCinEl;
	}
	public String getPrenomEl() {
		return prenomEl;
	}
	public void setPrenomEl(String prenomEl) {
		this.prenomEl = prenomEl;
	}
	public String getNomEl() {
		return nomEl;
	}
	public void setNomEl(String nomEl) {
		this.nomEl = nomEl;
	}
	public Date getDatenaissanceEl() {
		return datenaissanceEl;
	}
	public void setDatenaissanceEl(Date datenaissanceEl) {
		this.datenaissanceEl = datenaissanceEl;
	}
	public String getLieuNaissanceEl() {
		return lieuNaissanceEl;
	}
	public void setLieuNaissanceEl(String lieuNaissanceEl) {
		this.lieuNaissanceEl = lieuNaissanceEl;
	}
	public String getMailEl() {
		return mailEl;
	}
	public void setMailEl(String mailEl) {
		this.mailEl = mailEl;
	}
	public String getTelFamilleEl() {
		return telFamilleEl;
	}
	public void setTelFamilleEl(String telFamilleEl) {
		this.telFamilleEl = telFamilleEl;
	}
	public String getFixeFamilleEl() {
		return fixeFamilleEl;
	}
	public void setFixeFamilleEl(String fixeFamilleEl) {
		this.fixeFamilleEl = fixeFamilleEl;
	}
	public String getTelEl() {
		return telEl;
	}
	public void setTelEl(String telEl) {
		this.telEl = telEl;
	}
	public Long getNumDossierRecrueEl() {
		return numDossierRecrueEl;
	}
	public void setNumDossierRecrueEl(Long numDossierRecrueEl) {
		this.numDossierRecrueEl = numDossierRecrueEl;
	}
	public String getCategorie() {
		return categorie;
	}
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	public Grade getGrade() {
		return grade;
	}
	public void setGrade(Grade grade) {
		this.grade = grade;
	}
	public Gouvernorat getGouvernorat() {
		return gouvernorat;
	}
	public void setGouvernorat(Gouvernorat gouvernorat) {
		this.gouvernorat = gouvernorat;
	}
	public Delegation getDelegation() {
		return delegation;
	}
	public void setDelegation(Delegation delegation) {
		this.delegation = delegation;
	}
	public String getRueEl() {
		return rueEl;
	}
	public void setRueEl(String rueEl) {
		this.rueEl = rueEl;
	}
	public String getCodePostaleEl() {
		return codePostaleEl;
	}
	public void setCodePostaleEl(String codePostaleEl) {
		this.codePostaleEl = codePostaleEl;
	}
	public String getZonePoliceEl() {
		return zonePoliceEl;
	}
	public void setZonePoliceEl(String zonePoliceEl) {
		this.zonePoliceEl = zonePoliceEl;
	}
	public String getCentralPoliceEl() {
		return centralPoliceEl;
	}
	public void setCentralPoliceEl(String centralPoliceEl) {
		this.centralPoliceEl = centralPoliceEl;
	}
	public String getNivScolaireEl() {
		return nivScolaireEl;
	}
	public void setNivScolaireEl(String nivScolaireEl) {
		this.nivScolaireEl = nivScolaireEl;
	}
	public String getDiplomeEl() {
		return diplomeEl;
	}
	public void setDiplomeEl(String diplomeEl) {
		this.diplomeEl = diplomeEl;
	}
	public String getStagesEl() {
		return stagesEl;
	}
	public void setStagesEl(String stagesEl) {
		this.stagesEl = stagesEl;
	}
	public String getEtatMilitaireEl() {
		return etatMilitaireEl;
	}
	public void setEtatMilitaireEl(String etatMilitaireEl) {
		this.etatMilitaireEl = etatMilitaireEl;
	}
	public String getPassionEl() {
		return passionEl;
	}
	public void setPassionEl(String passionEl) {
		this.passionEl = passionEl;
	}
	public String getActiviteSportifEl() {
		return activiteSportifEl;
	}
	public void setActiviteSportifEl(String activiteSportifEl) {
		this.activiteSportifEl = activiteSportifEl;
	}
	public String getAssociationEl() {
		return associationEl;
	}
	public void setAssociationEl(String associationEl) {
		this.associationEl = associationEl;
	}
	public String getIdentitePereEl() {
		return identitePereEl;
	}
	public void setIdentitePereEl(String identitePereEl) {
		this.identitePereEl = identitePereEl;
	}
	public String getIdentiteMereEl() {
		return identiteMereEl;
	}
	public void setIdentiteMereEl(String identiteMereEl) {
		this.identiteMereEl = identiteMereEl;
	}
	public String getFonctionPereEl() {
		return fonctionPereEl;
	}
	public void setFonctionPereEl(String fonctionPereEl) {
		this.fonctionPereEl = fonctionPereEl;
	}
	public String getSocietePereEl() {
		return societePereEl;
	}
	public void setSocietePereEl(String societePereEl) {
		this.societePereEl = societePereEl;
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
	public Section getSection() {
		return section;
	}
	public void setSection(Section section) {
		this.section = section;
	}
	
	
	public byte[] getImageEl() {
		return imageEl;
	}
	public void setImageEl(byte[] imageEl) {
		this.imageEl = imageEl;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Date getDatenterEl() {
		return datenterEl;
	}
	public void setDatenterEl(Date datenterEl) {
		this.datenterEl = datenterEl;
	}
	public Time getTimeEnterEl() {
		return timeEnterEl;
	}
	public void setTimeEnterEl(Time timeEnterEl) {
		this.timeEnterEl = timeEnterEl;
	}

	
	public String getSexeEl() {
		return sexeEl;
	}
	public void setSexeEl(String sexeEl) {
		this.sexeEl = sexeEl;
	}
	
	public Specialite getSpecialite() {
		return specialite;
	}
	public void setSpecialite(Specialite specialite) {
		this.specialite = specialite;
	}
	public Eleve(long id, Long cinEl, Date dateCinEl, String prenomEl, String nomEl, Date datenaissanceEl,
			String lieuNaissanceEl, String mailEl, String telFamilleEl, String fixeFamilleEl, String telEl,
			byte[] imageEl, String fileName, Date datenterEl, Time timeEnterEl, String sexeEl, Long numDossierRecrueEl,
			String categorie, Grade grade, Gouvernorat gouvernorat, Delegation delegation, String rueEl,
			String codePostaleEl, String zonePoliceEl, String centralPoliceEl, String nivScolaireEl, String diplomeEl,
			String stagesEl, String etatMilitaireEl, String passionEl, String activiteSportifEl, String associationEl,
			String identitePereEl, String identiteMereEl, String fonctionPereEl, String societePereEl,
			long imageModelId, Session session, Group group, Company company, Section section) {
		super();
		this.id = id;
		this.cinEl = cinEl;
		this.dateCinEl = dateCinEl;
		this.prenomEl = prenomEl;
		this.nomEl = nomEl;
		this.datenaissanceEl = datenaissanceEl;
		this.lieuNaissanceEl = lieuNaissanceEl;
		this.mailEl = mailEl;
		this.telFamilleEl = telFamilleEl;
		this.fixeFamilleEl = fixeFamilleEl;
		this.telEl = telEl;
		this.imageEl = imageEl;
		this.fileName = fileName;
		this.datenterEl = datenterEl;
		this.timeEnterEl = timeEnterEl;
		this.sexeEl = sexeEl;
		this.numDossierRecrueEl = numDossierRecrueEl;
		this.categorie = categorie;
		this.grade = grade;
		this.gouvernorat = gouvernorat;
		this.delegation = delegation;
		this.rueEl = rueEl;
		this.codePostaleEl = codePostaleEl;
		this.zonePoliceEl = zonePoliceEl;
		this.centralPoliceEl = centralPoliceEl;
		this.nivScolaireEl = nivScolaireEl;
		this.diplomeEl = diplomeEl;
		this.stagesEl = stagesEl;
		this.etatMilitaireEl = etatMilitaireEl;
		this.passionEl = passionEl;
		this.activiteSportifEl = activiteSportifEl;
		this.associationEl = associationEl;
		this.identitePereEl = identitePereEl;
		this.identiteMereEl = identiteMereEl;
		this.fonctionPereEl = fonctionPereEl;
		this.societePereEl = societePereEl;
		this.imageModelId = imageModelId;
		this.session = session;
		this.group = group;
		this.company = company;
		this.section = section;
	}
	
	public Eleve(Long cinEl, Date dateCinEl, String prenomEl, String nomEl, Date datenaissanceEl,
			String lieuNaissanceEl, String mailEl, String telFamilleEl, String fixeFamilleEl, String telEl,
			byte[] imageEl, String fileName, Date datenterEl, Time timeEnterEl, String sexeEl, Long numDossierRecrueEl,
			String categorie, Grade grade, Gouvernorat gouvernorat, Delegation delegation, String rueEl,
			String codePostaleEl, String zonePoliceEl, String centralPoliceEl, String nivScolaireEl, String diplomeEl,
			String stagesEl, String etatMilitaireEl, String passionEl, String activiteSportifEl, String associationEl,
			String identitePereEl, String identiteMereEl, String fonctionPereEl, String societePereEl,
			long imageModelId, Session session, Group group, Company company, Section section) {
		super();
		this.cinEl = cinEl;
		this.dateCinEl = dateCinEl;
		this.prenomEl = prenomEl;
		this.nomEl = nomEl;
		this.datenaissanceEl = datenaissanceEl;
		this.lieuNaissanceEl = lieuNaissanceEl;
		this.mailEl = mailEl;
		this.telFamilleEl = telFamilleEl;
		this.fixeFamilleEl = fixeFamilleEl;
		this.telEl = telEl;
		this.imageEl = imageEl;
		this.fileName = fileName;
		this.datenterEl = datenterEl;
		this.timeEnterEl = timeEnterEl;
		this.sexeEl = sexeEl;
		this.numDossierRecrueEl = numDossierRecrueEl;
		this.categorie = categorie;
		this.grade = grade;
		this.gouvernorat = gouvernorat;
		this.delegation = delegation;
		this.rueEl = rueEl;
		this.codePostaleEl = codePostaleEl;
		this.zonePoliceEl = zonePoliceEl;
		this.centralPoliceEl = centralPoliceEl;
		this.nivScolaireEl = nivScolaireEl;
		this.diplomeEl = diplomeEl;
		this.stagesEl = stagesEl;
		this.etatMilitaireEl = etatMilitaireEl;
		this.passionEl = passionEl;
		this.activiteSportifEl = activiteSportifEl;
		this.associationEl = associationEl;
		this.identitePereEl = identitePereEl;
		this.identiteMereEl = identiteMereEl;
		this.fonctionPereEl = fonctionPereEl;
		this.societePereEl = societePereEl;
		this.imageModelId = imageModelId;
		this.session = session;
		this.group = group;
		this.company = company;
		this.section = section;
	}
	public Eleve(long id) {
		super();
		this.id = id;
	}
	public Eleve() {
		super();
	}
	@Override
	public String toString() {
		return "Eleve [id=" + id + ", cinEl=" + cinEl + ", dateCinEl=" + dateCinEl + ", prenomEl=" + prenomEl
				+ ", nomEl=" + nomEl + ", datenaissanceEl=" + datenaissanceEl + ", lieuNaissanceEl=" + lieuNaissanceEl
				+ ", mailEl=" + mailEl + ", telFamilleEl=" + telFamilleEl + ", fixeFamilleEl=" + fixeFamilleEl
				+ ", telEl=" + telEl + ", imageEl=" + Arrays.toString(imageEl) + ", fileName=" + fileName
				+ ", numDossierRecrueEl=" + numDossierRecrueEl + ", categorie=" + categorie + ", grade=" + grade
				+ ", gouvernorat=" + gouvernorat + ", delegation=" + delegation + ", rueEl=" + rueEl
				+ ", codePostaleEl=" + codePostaleEl + ", zonePoliceEl=" + zonePoliceEl + ", centralPoliceEl="
				+ centralPoliceEl + ", nivScolaireEl=" + nivScolaireEl + ", diplomeEl=" + diplomeEl + ", stagesEl="
				+ stagesEl + ", etatMilitaireEl=" + etatMilitaireEl + ", passionEl=" + passionEl
				+ ", activiteSportifEl=" + activiteSportifEl + ", associationEl=" + associationEl + ", identitePereEl="
				+ identitePereEl + ", identiteMereEl=" + identiteMereEl + ", fonctionPereEl=" + fonctionPereEl
				+ ", societePereEl=" + societePereEl + ", imageModel=" + imageModelId + ", session=" + session
				+ ", group=" + group + ", company=" + company + ", section=" + section + "]";
	}
	public Eleve(Long cinEl, long imageModelId) {
		super();
		this.cinEl = cinEl;
		this.imageModelId = imageModelId;
	}
	public Eleve(long id,byte[] img,  Long cinEl, String prenomEl, String nomEl, Date datenaissanceEl, String lieuNaissanceEl,
			String telEl, Long numDossierRecrueEl, Delegation delegation, String rueEl, String identitePereEl,
			String identiteMereEl) {
		super();
		this.id = id;
		this.cinEl = cinEl;
		this.prenomEl = prenomEl;
		this.nomEl = nomEl;
		this.datenaissanceEl = datenaissanceEl;
		this.lieuNaissanceEl = lieuNaissanceEl;
		this.telEl = telEl;
		this.numDossierRecrueEl = numDossierRecrueEl;
		this.delegation = delegation;
		this.rueEl = rueEl;
		this.identitePereEl = identitePereEl;
		this.identiteMereEl = identiteMereEl;
	}
	public Eleve(byte[] img, Long cinEl, String prenomEl, String nomEl, Date datenaissanceEl, String lieuNaissanceEl,
			String telEl, Long numDossierRecrueEl, Delegation delegation, String rueEl, String identitePereEl,
			String identiteMereEl) {
		super();
		this.cinEl = cinEl;
		this.prenomEl = prenomEl;
		this.nomEl = nomEl;
		this.datenaissanceEl = datenaissanceEl;
		this.lieuNaissanceEl = lieuNaissanceEl;
		this.telEl = telEl;
		this.numDossierRecrueEl = numDossierRecrueEl;
		this.delegation = delegation;
		this.rueEl = rueEl;
		this.identitePereEl = identitePereEl;
		this.identiteMereEl = identiteMereEl;
	}
	public Eleve(long id,byte[] img, Long cinEl, Long numDossierRecrueEl,String nomEl, String prenomEl, Date datenaissanceEl, String lieuNaissanceEl,
			String telEl, String rueEl, String identitePereEl,
			String identiteMereEl,Date datenterEl,Time timeEnterEl, String sexeEl) {
		
		this.cinEl = cinEl;
		this.numDossierRecrueEl = numDossierRecrueEl;
		this.nomEl = nomEl;
		this.prenomEl = prenomEl;
		this.datenaissanceEl = datenaissanceEl;
		this.lieuNaissanceEl = lieuNaissanceEl;
		this.telEl = telEl;
		this.rueEl = rueEl;
		this.identitePereEl = identitePereEl;
		this.identiteMereEl = identiteMereEl;
		this.datenterEl = datenterEl;
		this.timeEnterEl = timeEnterEl;
		this.sexeEl = sexeEl;
	}
	public Eleve(long id, byte[] img, Long cinEl, Date dateCinEl, String prenomEl, String nomEl, Date datenaissanceEl,
			String lieuNaissanceEl, String mailEl, String telFamilleEl, String fixeFamilleEl, String telEl,
			byte[] imageEl, String fileName, Date datenterEl, Time timeEnterEl, String sexeEl, Long numDossierRecrueEl,
			String categorie, Grade grade, Specialite specialite, Gouvernorat gouvernorat, Delegation delegation,
			String rueEl, String codePostaleEl, String zonePoliceEl, String centralPoliceEl, String nivScolaireEl,
			String diplomeEl, String stagesEl, String etatMilitaireEl, String passionEl, String activiteSportifEl,
			String associationEl, String identitePereEl, String identiteMereEl, String fonctionPereEl,
			String societePereEl, long imageModelId, Session session, Group group, Company company, Section section) {
		super();
		this.id = id;
		this.img = img;
		this.cinEl = cinEl;
		this.dateCinEl = dateCinEl;
		this.prenomEl = prenomEl;
		this.nomEl = nomEl;
		this.datenaissanceEl = datenaissanceEl;
		this.lieuNaissanceEl = lieuNaissanceEl;
		this.mailEl = mailEl;
		this.telFamilleEl = telFamilleEl;
		this.fixeFamilleEl = fixeFamilleEl;
		this.telEl = telEl;
		this.imageEl = imageEl;
		this.fileName = fileName;
		this.datenterEl = datenterEl;
		this.timeEnterEl = timeEnterEl;
		this.sexeEl = sexeEl;
		this.numDossierRecrueEl = numDossierRecrueEl;
		this.categorie = categorie;
		this.grade = grade;
		this.specialite = specialite;
		this.gouvernorat = gouvernorat;
		this.delegation = delegation;
		this.rueEl = rueEl;
		this.codePostaleEl = codePostaleEl;
		this.zonePoliceEl = zonePoliceEl;
		this.centralPoliceEl = centralPoliceEl;
		this.nivScolaireEl = nivScolaireEl;
		this.diplomeEl = diplomeEl;
		this.stagesEl = stagesEl;
		this.etatMilitaireEl = etatMilitaireEl;
		this.passionEl = passionEl;
		this.activiteSportifEl = activiteSportifEl;
		this.associationEl = associationEl;
		this.identitePereEl = identitePereEl;
		this.identiteMereEl = identiteMereEl;
		this.fonctionPereEl = fonctionPereEl;
		this.societePereEl = societePereEl;
		this.imageModelId = imageModelId;
		this.session = session;
		this.group = group;
		this.company = company;
		this.section = section;
	}
	public Eleve(byte[] img, Long cinEl, Date dateCinEl, String prenomEl, String nomEl, Date datenaissanceEl,
			String lieuNaissanceEl, String mailEl, String telFamilleEl, String fixeFamilleEl, String telEl,
			byte[] imageEl, String fileName, Date datenterEl, Time timeEnterEl, String sexeEl, Long numDossierRecrueEl,
			String categorie, Grade grade, Specialite specialite, Gouvernorat gouvernorat, Delegation delegation,
			String rueEl, String codePostaleEl, String zonePoliceEl, String centralPoliceEl, String nivScolaireEl,
			String diplomeEl, String stagesEl, String etatMilitaireEl, String passionEl, String activiteSportifEl,
			String associationEl, String identitePereEl, String identiteMereEl, String fonctionPereEl,
			String societePereEl, long imageModelId, Session session, Group group, Company company, Section section) {
		super();
		this.img = img;
		this.cinEl = cinEl;
		this.dateCinEl = dateCinEl;
		this.prenomEl = prenomEl;
		this.nomEl = nomEl;
		this.datenaissanceEl = datenaissanceEl;
		this.lieuNaissanceEl = lieuNaissanceEl;
		this.mailEl = mailEl;
		this.telFamilleEl = telFamilleEl;
		this.fixeFamilleEl = fixeFamilleEl;
		this.telEl = telEl;
		this.imageEl = imageEl;
		this.fileName = fileName;
		this.datenterEl = datenterEl;
		this.timeEnterEl = timeEnterEl;
		this.sexeEl = sexeEl;
		this.numDossierRecrueEl = numDossierRecrueEl;
		this.categorie = categorie;
		this.grade = grade;
		this.specialite = specialite;
		this.gouvernorat = gouvernorat;
		this.delegation = delegation;
		this.rueEl = rueEl;
		this.codePostaleEl = codePostaleEl;
		this.zonePoliceEl = zonePoliceEl;
		this.centralPoliceEl = centralPoliceEl;
		this.nivScolaireEl = nivScolaireEl;
		this.diplomeEl = diplomeEl;
		this.stagesEl = stagesEl;
		this.etatMilitaireEl = etatMilitaireEl;
		this.passionEl = passionEl;
		this.activiteSportifEl = activiteSportifEl;
		this.associationEl = associationEl;
		this.identitePereEl = identitePereEl;
		this.identiteMereEl = identiteMereEl;
		this.fonctionPereEl = fonctionPereEl;
		this.societePereEl = societePereEl;
		this.imageModelId = imageModelId;
		this.session = session;
		this.group = group;
		this.company = company;
		this.section = section;
	}
	public Eleve(long id, byte[] img, Long cinEl, Date dateCinEl, String prenomEl, String nomEl, Date datenaissanceEl,
			String lieuNaissanceEl, String mailEl, String telFamilleEl, String fixeFamilleEl, String telEl,
			byte[] imageEl, String fileName, Date datenterEl, Time timeEnterEl, String sexeEl, Long numDossierRecrueEl,
			String categorie, Grade grade, Specialite specialite, Etatcivil etatcivil, Gouvernorat gouvernorat,
			Delegation delegation, String rueEl, String codePostaleEl, String zonePoliceEl, String centralPoliceEl,
			String nivScolaireEl, String diplomeEl, String stagesEl, String etatMilitaireEl, String passionEl,
			String activiteSportifEl, String associationEl, String identitePereEl, String identiteMereEl,
			String fonctionPereEl, String societePereEl, long imageModelId, Session session, Group group,
			Company company, Section section) {
		super();
		this.id = id;
		this.img = img;
		this.cinEl = cinEl;
		this.dateCinEl = dateCinEl;
		this.prenomEl = prenomEl;
		this.nomEl = nomEl;
		this.datenaissanceEl = datenaissanceEl;
		this.lieuNaissanceEl = lieuNaissanceEl;
		this.mailEl = mailEl;
		this.telFamilleEl = telFamilleEl;
		this.fixeFamilleEl = fixeFamilleEl;
		this.telEl = telEl;
		this.imageEl = imageEl;
		this.fileName = fileName;
		this.datenterEl = datenterEl;
		this.timeEnterEl = timeEnterEl;
		this.sexeEl = sexeEl;
		this.numDossierRecrueEl = numDossierRecrueEl;
		this.categorie = categorie;
		this.grade = grade;
		this.specialite = specialite;
		this.etatcivil = etatcivil;
		this.gouvernorat = gouvernorat;
		this.delegation = delegation;
		this.rueEl = rueEl;
		this.codePostaleEl = codePostaleEl;
		this.zonePoliceEl = zonePoliceEl;
		this.centralPoliceEl = centralPoliceEl;
		this.nivScolaireEl = nivScolaireEl;
		this.diplomeEl = diplomeEl;
		this.stagesEl = stagesEl;
		this.etatMilitaireEl = etatMilitaireEl;
		this.passionEl = passionEl;
		this.activiteSportifEl = activiteSportifEl;
		this.associationEl = associationEl;
		this.identitePereEl = identitePereEl;
		this.identiteMereEl = identiteMereEl;
		this.fonctionPereEl = fonctionPereEl;
		this.societePereEl = societePereEl;
		this.imageModelId = imageModelId;
		this.session = session;
		this.group = group;
		this.company = company;
		this.section = section;
	}
	public Eleve(byte[] img, Long cinEl, Date dateCinEl, String prenomEl, String nomEl, Date datenaissanceEl,
			String lieuNaissanceEl, String mailEl, String telFamilleEl, String fixeFamilleEl, String telEl,
			byte[] imageEl, String fileName, Date datenterEl, Time timeEnterEl, String sexeEl, Long numDossierRecrueEl,
			String categorie, Grade grade, Specialite specialite, Etatcivil etatcivil, Gouvernorat gouvernorat,
			Delegation delegation, String rueEl, String codePostaleEl, String zonePoliceEl, String centralPoliceEl,
			String nivScolaireEl, String diplomeEl, String stagesEl, String etatMilitaireEl, String passionEl,
			String activiteSportifEl, String associationEl, String identitePereEl, String identiteMereEl,
			String fonctionPereEl, String societePereEl, long imageModelId, Session session, Group group,
			Company company, Section section) {
		super();
		this.img = img;
		this.cinEl = cinEl;
		this.dateCinEl = dateCinEl;
		this.prenomEl = prenomEl;
		this.nomEl = nomEl;
		this.datenaissanceEl = datenaissanceEl;
		this.lieuNaissanceEl = lieuNaissanceEl;
		this.mailEl = mailEl;
		this.telFamilleEl = telFamilleEl;
		this.fixeFamilleEl = fixeFamilleEl;
		this.telEl = telEl;
		this.imageEl = imageEl;
		this.fileName = fileName;
		this.datenterEl = datenterEl;
		this.timeEnterEl = timeEnterEl;
		this.sexeEl = sexeEl;
		this.numDossierRecrueEl = numDossierRecrueEl;
		this.categorie = categorie;
		this.grade = grade;
		this.specialite = specialite;
		this.etatcivil = etatcivil;
		this.gouvernorat = gouvernorat;
		this.delegation = delegation;
		this.rueEl = rueEl;
		this.codePostaleEl = codePostaleEl;
		this.zonePoliceEl = zonePoliceEl;
		this.centralPoliceEl = centralPoliceEl;
		this.nivScolaireEl = nivScolaireEl;
		this.diplomeEl = diplomeEl;
		this.stagesEl = stagesEl;
		this.etatMilitaireEl = etatMilitaireEl;
		this.passionEl = passionEl;
		this.activiteSportifEl = activiteSportifEl;
		this.associationEl = associationEl;
		this.identitePereEl = identitePereEl;
		this.identiteMereEl = identiteMereEl;
		this.fonctionPereEl = fonctionPereEl;
		this.societePereEl = societePereEl;
		this.imageModelId = imageModelId;
		this.session = session;
		this.group = group;
		this.company = company;
		this.section = section;
	}
	public Eleve(Eleve el) {
		super();
		this.id = el.id;
		this.img = null;
		this.cinEl = el.cinEl;
		this.dateCinEl = el.dateCinEl;
		this.prenomEl = el.prenomEl;
		this.nomEl = el.nomEl;
		this.datenaissanceEl = el.datenaissanceEl;
		this.lieuNaissanceEl = el.lieuNaissanceEl;
		this.mailEl = el.mailEl;
		this.telFamilleEl = el.telFamilleEl;
		this.fixeFamilleEl = el.fixeFamilleEl;
		this.telEl = el.telEl;
		this.imageEl = el.imageEl;
		this.fileName = el.fileName;
		this.datenterEl = el.datenterEl;
		this.timeEnterEl = el.timeEnterEl;
		this.sexeEl = el.sexeEl;
		this.numDossierRecrueEl = el.numDossierRecrueEl;
		this.categorie = el.categorie;
		this.grade = el.grade;
		this.specialite = el.specialite;
		this.etatcivil = el.etatcivil;
		this.gouvernorat = el.gouvernorat;
		this.delegation = el.delegation;
		this.rueEl = el.rueEl;
		this.codePostaleEl = el.codePostaleEl;
		this.zonePoliceEl = el.zonePoliceEl;
		this.centralPoliceEl = el.centralPoliceEl;
		this.nivScolaireEl = el.nivScolaireEl;
		this.diplomeEl = el.diplomeEl;
		this.stagesEl = el.stagesEl;
		this.etatMilitaireEl = el.etatMilitaireEl;
		this.passionEl = el.passionEl;
		this.activiteSportifEl = el.activiteSportifEl;
		this.associationEl = el.associationEl;
		this.identitePereEl = el.identitePereEl;
		this.identiteMereEl = el.identiteMereEl;
		this.fonctionPereEl = el.fonctionPereEl;
		this.societePereEl = el.societePereEl;
		this.imageModelId = el.imageModelId;
		this.session = el.session;
		this.group = el.group;
		this.company = el.company;
		this.section = el.section;
	}
	public Eleve(long id, Session session, Company company) {
		super();
		this.id = id;
		this.session = session;
		this.company = company;
	}
	

	
}