package com.enpr.dao;


import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.enpr.model.Eleve;
import com.enpr.model.ElvPreselection;

@Repository
public interface Elv_preselectionRepository extends  CrudRepository<ElvPreselection, Long> {	
	/*@Query("Delete s FROM ElvPreselection s WHERE s.numDossierRecrueEl = ?1 ")
	ElvPreselection deleteByNumDossierRecrue(Long numD);*/
	
	/*@Query("Delete FROM ElvPreselection s where s.numdossier = ?1")
	void deleteNumdossier(long numdossier);*/
	
}
