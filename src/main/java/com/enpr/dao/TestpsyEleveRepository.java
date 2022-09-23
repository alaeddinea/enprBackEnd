package com.enpr.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.enpr.model.TestpsyEleve;

@Repository
public interface TestpsyEleveRepository extends  CrudRepository<TestpsyEleve, Long> {
	@Query("SELECT s FROM TestpsyEleve s WHERE s.eleve.id = ?1 ")
	List<TestpsyEleve> findAllSonByMother(Long id);
}

