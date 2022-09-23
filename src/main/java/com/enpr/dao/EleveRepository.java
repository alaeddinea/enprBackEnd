package com.enpr.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.enpr.model.Eleve;
@Repository
public interface EleveRepository  extends CrudRepository<Eleve, Long>{
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query("update Eleve u set u.img = :status where u.id = :id")
	int updateEleveSetImgForId(@Param("status") byte[]  status,  @Param("id") Long id);
	@Query("SELECT s FROM Eleve s WHERE s.section.id = ?1 ORDER BY sexeEl DESC ")
	List<Eleve> findAllEleveBySection(Long id);
	@Query("SELECT s FROM Eleve s WHERE s.company.id = ?1  ORDER BY sexeEl DESC ")
	List<Eleve> findAllEleveByCompany(Long id);
	@Query("SELECT s FROM Eleve s WHERE s.group.id = ?1  ORDER BY sexeEl DESC ")
	List<Eleve> findAllEleveByGroup(Long id);
	@Query("SELECT s FROM Eleve s WHERE s.session.id = ?1  ORDER BY sexeEl DESC ")
	List<Eleve> findAllEleveBySession(Long id);

        /*@Query("SELECT s.id, s.session , s.company FROM Eleve s WHERE s.session.id = ?1  ")
		List<Eleve> findAllEleveBySessionTest(Long id);*/
	@Query("SELECT s FROM Eleve s WHERE s.cinEl = ?1  ORDER BY sexeEl DESC ")
	List<Eleve> findAllEleveByCin(Long cin);
	@Query("SELECT s FROM Eleve s WHERE s.numDossierRecrueEl = ?1  ORDER BY sexeEl DESC ")
	List<Eleve> findAllEleveByNumDossierRecrue(Long numD);
}


//@Query("SELECT s.company, s.image_el, s.time_enter_el, s.central_police_el, s.etatcivilfk, s.gradefk, s.etat_militaire_el, s.societe_pere_el, s.specialitefk, s.file_name, s.identite_pere_el, s.nom_el, s.ispaire, s.fonction_pere_el, s.delegationfk, s.stages_el, s.identite_mere_el, s.activite_sportif_el, s.id, s.zone_police_el, s.gouvernoratfk, s.rue_el, s.cin_el, s.img, s.num_dossier_recrue_el, s.passion_el, s.sectionfk, s.sessionfk, s.diplome_el, s.tel_el, s.groupfk, s.datenaissance_el, s.niv_scolaire_el, s.lieu_naissance_el, s.image_model_id, s.tel_famille_el, s.prenom_el, s.date_cin_el, s.fixe_famille_el, s.categorie, s.code_postale_el, s.sexe_el, s.mail_el, s.association_el, s.datenter_el FROM Eleve s WHERE s.session.id = ?1  ORDER BY sexeEl DESC ")

//, s.cinEl, s.dateCinEl, s.prenomEl, s.nomEl, s.datenaissanceEl, s.lieuNaissanceEl, s.mailEl, s.telFamilleEl, s.fixeFamilleEl, s.telEl, s.imageEl, s.fileName, s.numDossierRecrueEl, s.categorie, s.grade, s.specialite, s.etatcivil , s.gouvernorat, s.delegation,  s.rueEl, s.codePostaleEl, s.zonePoliceEl, s.centralPoliceEl, s.nivScolaireEl, s.diplomeEl, s.stagesEl, s.etatMilitaireEl, s.passionEl,   s.activiteSportifEl, s.associationEl, s.identitePereEl, s.identiteMereEl, s.fonctionPereEl, s.societePereEl, s.session, s.group,    s.company, s.section, s.selectedFile, s.imageModelId, s.datenterEl, s.timeEnterEl, s.sexeEl