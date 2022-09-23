package com.enpr.dao;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.enpr.model.RepoEleve;

@Repository
public interface RepoEleveRepository extends  CrudRepository<RepoEleve, Long> {
	@Query("SELECT s FROM RepoEleve s WHERE s.eleve.id = ?1 ")
	List<RepoEleve> findAllSonByMother(Long id);
	
	@Query(value = "SELECT rp.DATE_DEBUT_REPO,rp.DATE_FIN_REPO, el.num_dossier_recrue_el, el.cin_el,el.prenom_el, el.identite_pere_el, el.nom_el  , gp.nom_group, cp.num_company ,sc.num_section , md.nom_medicale,se.NUM_SESSION,gd.LIBELLE_GRADE"
			+ " FROM RepoElevetb rp , elevetb el , medicaletb md, sessiontb se,grade gd, grouptb gp , companytb cp, sectiontb sc "
			+ "WHERE rp.elevefk=el.id and rp.medicalefk =md.id and  el.sessionfk=se.id and el.GRADEFK=gd.id and  el.groupfk=gp.id and el.companyfk= cp.id and el.sectionfk=sc.id  "
			+ "AND rp.date_fin_repo >= ?1 "
			+ "ORDER BY se.NUM_SESSION,gp.nom_group, cp.num_company ,sc.num_section "
			
			  /* or rp.DATE_FIN_REPO <= ?2 ;" */,
			  nativeQuery = true)
	List<Object> getExcelRepo ( Date  date );
}
