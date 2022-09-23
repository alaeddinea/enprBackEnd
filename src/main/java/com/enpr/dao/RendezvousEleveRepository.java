package com.enpr.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import com.enpr.model.RendezvousEleve;

public interface RendezvousEleveRepository extends  CrudRepository<RendezvousEleve, Long> { 
	@Query("SELECT s FROM RendezvousEleve s WHERE s.eleve.id = ?1 ")
	List<RendezvousEleve> findAllSonByMother(Long id);
	@Query("SELECT s FROM RendezvousEleve s WHERE s.dateRendezvous < ?1 ")
	List<RendezvousEleve> findAllRendezvousbetween(Date date);
	
	List<RendezvousEleve> findByDateRendezvousBetween(Date dated,Date datef);


}
