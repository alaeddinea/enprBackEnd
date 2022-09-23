package com.enpr.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.enpr.model.PenaliteEleve;
import com.enpr.model.Section;

@Repository
public interface PenaliteEleveRepository extends CrudRepository<PenaliteEleve, Long> {
	@Query("SELECT s FROM PenaliteEleve s WHERE s.eleve.id = ?1 ")
	List<PenaliteEleve> findAllSonByMother(Long id);
}
