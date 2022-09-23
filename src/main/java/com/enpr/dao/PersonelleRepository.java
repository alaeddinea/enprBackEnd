package com.enpr.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import com.enpr.model.Personelle;

public interface PersonelleRepository extends CrudRepository<Personelle, Long> {
	@Query("SELECT p FROM Personelle p WHERE p.matricule = ?1")
	Personelle findByMatricule (Long matricule);
	
	/*@Query("SELECT s FROM Personelle s WHERE s.matricule = ?1")
	List<Personelle> findAllPersonelleByCnrps(String  matricule);*/
}
