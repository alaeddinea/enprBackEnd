package com.enpr.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.enpr.model.VaccinEleve;

@Repository
public interface VaccinEleveRepository extends  CrudRepository<VaccinEleve, Long> {
	@Query("SELECT s FROM VaccinEleve s WHERE s.eleve.id = ?1 ")
	List<VaccinEleve> findAllSonByMother(Long id);
}